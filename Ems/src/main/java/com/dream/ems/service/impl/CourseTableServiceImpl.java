package com.dream.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.dream.ems.po.*;
import com.dream.ems.repository.*;
import com.dream.ems.service.MajorService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.service.CourseTableService;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class CourseTableServiceImpl implements CourseTableService {
    @Resource
    private CourseTableRepository courseTableRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private CourseTableStudentRepository courseTableStudentRepository;
    @Resource
    private MajorRepository majorRepository;

    @Override
    public List<CourseTableDto> getByMid(String majorId) {

        List<CourseTable> pos = courseTableRepository.findAllByMajorId(majorId);
        List<CourseTableDto> dtos = CourseTableDto.getDtos(pos);
        return dtos;
    }

    @Override
    public Integer getStuNumberByCtId(Integer id) {
        return courseTableStudentRepository.countStusByCtId(id);
    }

    @Override
    public List<CourseTableDto> getCourseTable(String collegeId, String majorId) {
        List<CourseTable> pos = courseTableStudentRepository.findAllByCollegeIdAndMajorId(collegeId, majorId);
        List<CourseTableDto> dtos = CourseTableDto.getDtos(pos);
        return dtos;
    }

    @Override
    public void deleteByIdIn(List<Integer> courseTableIds) {
        courseTableRepository.deleteByIdIn(courseTableIds);
    }

    @Override
    public void saveCourseTables(List<CourseTable> pos) {
        List<Student> students = studentRepository.findAllStudentByMajorId(pos.get(0).getMajor().getId());
        for (CourseTable po : pos) {
            po.setStudents(students);
            courseTableRepository.save(po);
        }
    }

    @Override
    public void deleteByMajorId(String majorId) {
        courseTableRepository.deleteByMajorId(majorId);
    }

    @Override
    public CourseTableDto getTableByid(Integer id) {
        CourseTable po = courseTableRepository.findById(id).get();
        CourseTableDto dto = new CourseTableDto(po);
        return dto;
    }

    @Override
    public void saveElectiveCoursePlan(CourseTableDto data) {
        Major major = majorRepository.findById(data.getMajorId()).get();
        CourseTable po = data.createPo();
        po.setCollege(major.getCollege());
        courseTableRepository.save(po);
    }

    @Override
    public WoPage<CourseTableDto> getPageData(String param, Long start, Long length, String searchContent, String dir) {
        ExampleMatcher m = ExampleMatcher.matching();
        CourseTable qo = new CourseTable();
        if (!WoUtil.isEmpty(searchContent)) {
            Teacher t = new Teacher();
            m.withMatcher("teacher.name", GenericPropertyMatchers.contains());
            t.setName(searchContent);
            qo.setTeacher(t);
        }
        if (!WoUtil.isEmpty(param)) {
            Course c = new Course();
            m.withMatcher("course.id", GenericPropertyMatchers.contains());
            c.setId(param);
            qo.setCourse(c);
        }

        Example<CourseTable> ex = Example.of(qo, m);
        Pageable p = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
        Page<CourseTable> page = courseTableRepository.findAll(ex, p);
        return new WoPage<CourseTableDto>(CourseTableDto.getDtos(page.getContent()), page.getTotalElements());
    }

    @Override
    public CourseTableDto findById(String id) {
        CourseTable po = courseTableRepository.findById(Integer.parseInt(id)).get();
        return new CourseTableDto(po);
    }

    @Override
    public void updateCourseTable(CourseTableDto dto) {
        courseTableRepository.save(dto.updatePo());
    }

    @Override
    public WoPage<CourseTableDto> getAllMyDataTable(Long start, Long length, String searchContent, String dir, String studentId) {
        Student student = studentRepository.findById(studentId).get();
        String majorId = student.getMajor().getId();
        Page<CourseTable> pageData;
        Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());

        if (WoUtil.isEmpty(searchContent)) {
            pageData = courseTableRepository.findAllByIsOptional(majorId, "6", pageInput);
        } else {
            pageData = courseTableRepository.findAllByIsOptionalAndNameLike("%" + searchContent + "%", majorId, "6", pageInput);
        }
        // 将PO转化为DTO
        return new WoPage<>(CourseTableDto.getDtos(pageData.getContent()), pageData.getTotalElements());
    }

    @Override
    public void deleteCourseTable(String[] id) {
        if (!WoUtil.isEmpty(id)) {
            Integer[] ids = new Integer[id.length];
            for (int i = 0; i < id.length; i++) {
                ids[i] = Integer.parseInt(id[i]);
            }
            courseTableRepository.deleteByIdIn(ids);
        }

    }

    @Override
    public List<CourseTable> getAllByTeacherJobNo(List<String> jobNoes) {
        if (!WoUtil.isEmpty(jobNoes) && jobNoes.size() > 0) {
            return courseTableRepository.findAllByTeacherJobNoIn(jobNoes);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<CourseTableDto> findAllByCourseAndTeacher(String id, String jobNo) {
        List<CourseTable> pos = courseTableRepository.findAllByCourseAndTeacher(id, jobNo);
        return CourseTableDto.getDtos(pos);
    }

    @Override
    public List<CourseTableDto> findAllByClazz(String stuNo, String semesterId) {
        Student student = studentRepository.findById(stuNo).get();
        List<CourseTable> pos = courseTableRepository.findAllByClazz(student.getClazz().getId(), semesterId);
        List<CourseTableStudent> list = courseTableStudentRepository.findAllByStudentStuNo(stuNo);
        if (list.size() > 0) {
            List<Integer> ids = new ArrayList<>();
            for (CourseTableStudent c : list) {
                ids.add(c.getCoursetableId());
            }
            List<CourseTable> pos1 = courseTableRepository.findAllByCourseTableIdIn(ids);
            pos.addAll(pos1);
        }
        return CourseTableDto.getDtos(pos);
    }
}