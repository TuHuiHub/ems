package com.dream.ems.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.dream.ems.po.*;
import com.dream.ems.repository.*;
import com.dream.ems.service.ClassRoomService;
import com.dream.ems.service.ClazzService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;

import com.dream.ems.dto.CourseDto;
import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.service.CourseService;
import com.dream.ems.vo.SelectCourseData;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {


    @Resource
    private CourseRepository courseRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private TeacherCourseRepository teacherCourseRepository;
    @Resource
    private StudentCourseRepository studentCourseRepository;
    @Resource
    private CourseTableRepository courseTableRepository;
    @Resource
    private ClassRoomRepository classRoomRepository;
    @Resource
    private ClassRoomService classRoomService;
    @Resource
    private ClazzService clazzService;

    @Override
    public WoPage<CourseDto> getPageData(MajorDto dto, Long start, Long length, String searchContent, String dir) {
        ExampleMatcher m = ExampleMatcher.matching();
        Course qo = new Course();
        if (!WoUtil.isEmpty(searchContent)) {
            m.withMatcher("name", GenericPropertyMatchers.contains());
            qo.setName(searchContent);
        }
        if (!WoUtil.isEmpty(dto.getId())) {
            m.withMatcher("major.id", GenericPropertyMatchers.exact());
            Major major = new Major();
            major.setId(dto.getId());
            qo.setMajor(major);
        }
        Example<Course> course = Example.of(qo, m);
        Pageable p = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
        Page<Course> page = courseRepository.findAll(course, p);
        return new WoPage<CourseDto>(CourseDto.getDtos(page.getContent()), page.getTotalElements());
    }

    @Override
    public void create(CourseDto dto) {
        Course course = dto.createPO();
        courseRepository.save(course);
    }

    @Override
    public CourseDto getById(String id) {
        Course po = courseRepository.findById(id).get();
        return new CourseDto(po);
    }

    @Override
    public void update(CourseDto dto) {
        Course po = courseRepository.findById(dto.getId()).get();
        dto.update(po);
        courseRepository.save(po);
    }

    @Override
    public void delete(String[] id) {
        courseRepository.deleteByIdIn(id);
    }

    @Override
    public WoPage<CourseDto> getPageData(Long start, Long length, String searchContent, String dir) {
        // 构造分页参数
        Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
        // 调用repository方法，获取po数据
        Page<Course> pageData = null;
        if (WoUtil.isEmpty(searchContent)) {
            pageData = courseRepository.findAll(pageInput);
        } else {
            pageData = courseRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
        }
        // 将PO转化为DTO
        WoPage<CourseDto> pr = CourseDto.getPageData(pageData.getContent(), pageData.getTotalElements());
        return pr;
    }

    @Override
    public Map<String, Object> selectCourse(CourseTableDto dto) {
        Course course = courseRepository.getOne(dto.getCourseId());
        Map<String, Object> map = new HashMap<>();
        // 判断该时间段该教师有无课程
        CourseTable c1 = courseTableRepository.teacherIsFree(dto.getTeacherJobNo(), dto.getWeekDay(), dto.getLesson());
        if (c1 != null) {
            map.put("status", 1);
            return map;
        }
        // 判断该时间段教室是否空闲
        CourseTable c2 = courseTableRepository.isClassRoomFree(dto.getClassRoomId(), dto.getWeekDay(), dto.getLesson());
        if (c2 != null) {
            map.put("status", 2);
            return map;
        }
        // 判断班级是否排完该课程
        // 每周安排次数
        Long t1 = (long) (Integer.parseInt(course.getCourseWeek()) / (Integer.parseInt(course.getEndWeek()) - Integer.parseInt(course.getStartWeek()) + 1));
        Long t2 = courseTableRepository.isClazzFree(dto.getCourseId(), dto.getClazzId());
        if (t2 >= t1) {
            map.put("status", 3);
            return map;
        }

        CourseTable po = dto.createPo();
        courseTableRepository.save(po);

        // 获取未排满课程的班级
        List<Clazz> clazzes = clazzService.getFreeClazz(dto.getMajorId(), course.getId());
        // 获取该时间段空闲的教室
        List<ClassRoom> classRooms = classRoomService.getAllRoomsByTime(dto.getWeekDay(), dto.getLesson());
        map.put("clazzes", clazzes);
        map.put("classRooms", classRooms);
        map.put("status", 0);
        return map;
    }

    @Override
    public List<Course> getAllByMajorId(String majorId) {
        List<Course> courses = courseRepository.findAllByMajorId(majorId);
        return courses;
    }

    @Override
    public WoPage<CourseDto> getAllDataTable(Long start, Long length, String searchContent, String dir) {
        Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue(), "desc".equals(dir) ? Direction.DESC : Direction.ASC, "isOptional");
        // 调用repository方法，获取po数据
        Page<Course> pageData = null;
        if (WoUtil.isEmpty(searchContent)) {
            pageData = courseRepository.findAll(pageInput);
        } else {
            pageData = courseRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
        }
        // 将PO转化为DTO
        WoPage<CourseDto> pr = CourseDto.getPageData(pageData.getContent(), pageData.getTotalElements());
        return pr;
    }

    @Override
    public List<Course> getAllByMajorIdAndSemesterId(String majorId, String semesterId) {
        return courseRepository.findAllByMajorIdAndSemesterId(majorId, semesterId);
    }


}
