package com.dream.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.dream.ems.po.Student;
import com.dream.ems.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.po.CourseTable;
import com.dream.ems.po.CourseTableStudent;
import com.dream.ems.po.StudentCourse;
import com.dream.ems.repository.CourseTableRepository;
import com.dream.ems.repository.CourseTableStudentRepository;
import com.dream.ems.repository.StudentCourseRepository;
import com.dream.ems.service.StudentCourseService;

import wo.bsys.util.BSysConstant;
import wo.bsys.util.BSysUtil;
import wo.bsys.vo.WoUser;
import wo.common.exception.WoException;

@Service
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService {


    @Resource
    private StudentCourseRepository studentCourseRepository;

    @Resource
    private CourseTableRepository courseTableRepository;

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<StudentCourseDto> getStudentList(String sId) {
        List<StudentCourse> pos = studentCourseRepository.findAllByStudentStuNo(sId);
        List<StudentCourseDto> dtos = new ArrayList<>();

        for (StudentCourse studentCourse : pos) {
            StudentCourseDto dto = new StudentCourseDto(studentCourse);
            dtos.add(dto);
        }
        return dtos;
    }

    @Resource
    private CourseTableStudentRepository courseTableStudentRepository;

    @Override
    public int chooseCourse(String id, Map<String, Object> map) {
        String[] ids = id.split(",");

        WoUser user = BSysUtil.getCurrentUser(map);
        String stuNo = user.getLoginName();
        Student student = studentRepository.findById(stuNo).get();
        List<CourseTableStudent> list = courseTableStudentRepository.findAllByStudentStuNo(stuNo);
        List<CourseTable> course1 = courseTableRepository.findAllByClazz(student.getClazz().getId(), "6");
        if (list.size() > 0) {
            List<Integer> ints = new ArrayList<>();
            for (CourseTableStudent c : list) {
                ints.add(c.getCoursetableId());
            }
            List<CourseTable> course2 = courseTableRepository.findAllByCourseTableIdIn(ints);
            course1.addAll(course2);
        }
        for (String s : ids) {
            CourseTable table = courseTableRepository.findById(Integer.parseInt(s)).get();

            for (CourseTable courseTable : course1) {
                if (s.equals(String.valueOf(courseTable.getId()))) {
                    return 0;
                }
                if (table.getWeekDay().equals(courseTable.getWeekDay()) && table.getLesson().equals(courseTable.getLesson())) {
                    return 0;
                }
            }
            for (CourseTableStudent cs : list) {
                Integer coursetableId = cs.getCoursetableId();
                CourseTable oldTable = courseTableRepository.findById(coursetableId).get();
                CourseTable courseInfo = courseTableRepository.findById(Integer.valueOf(s)).get();

                int oldStart = Integer.parseInt(oldTable.getStartWeek());
                int oldEnd = Integer.parseInt(oldTable.getEndWeek());
                int newStart = Integer.parseInt(courseInfo.getStartWeek());
                int newEnd = Integer.parseInt(courseInfo.getEndWeek());

                if ((oldStart <= newStart && newStart <= oldEnd) || (oldStart <= newEnd && newEnd <= oldEnd)) {
                    if (oldTable.getLesson().equals(courseInfo.getLesson()) && oldTable.getWeekDay().equals(courseInfo.getWeekDay())) {
                        throw new WoException(BSysConstant.ERR_CHOOSE_CLASS);
                    }
                }
                if (Integer.valueOf(s) == coursetableId) {
                    throw new WoException(BSysConstant.ERR_CHOOSE);
                }
            }
            CourseTableStudent cts = new CourseTableStudent();
            cts.setCoursetableId(Integer.valueOf(s));
            cts.setStudentStuNo(stuNo);
            courseTableStudentRepository.save(cts);
            return 1;
        }
        return 0;
    }
}

