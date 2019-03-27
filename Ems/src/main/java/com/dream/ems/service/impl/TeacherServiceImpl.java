package com.dream.ems.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.dto.TeacherCourseDto;
import com.dream.ems.dto.TeacherDto;
import com.dream.ems.po.CourseTable;
import com.dream.ems.po.StudentCourse;
import com.dream.ems.po.Teacher;
import com.dream.ems.po.TeacherCourse;
import com.dream.ems.repository.CourseTableRepository;
import com.dream.ems.repository.StudentCourseRepository;
import com.dream.ems.repository.TeacherCourseRepository;
import com.dream.ems.repository.TeacherRepository;
import com.dream.ems.service.TeacherService;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	private static Logger LOG = LogManager.getLogger(TeacherServiceImpl.class);
	@Resource
	private TeacherRepository teacherRepository;
	@Resource
	private TeacherCourseRepository teacherCourseRepository;
	@Resource
	private StudentCourseRepository studentCourseRepository;
	@Resource
	private CourseTableRepository courseTableRepository;
	@Override
	public WoPage<TeacherDto> getPageData(Long start, Long length, String searchContent, String dir) {
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<Teacher> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = teacherRepository.findAll(pageInput);
		} else {
			pageData = teacherRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<TeacherDto> pr = TeacherDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}
	@Override
	public TeacherDto getTeacher(String userId) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherRepository.findByUserId(userId);
		return new TeacherDto(teacher);
	}
	
	@Override
	public List<TeacherCourseDto> getTeacherList(String tId, String dir) {
		// TODO Auto-generated method stub
		List<TeacherCourseDto> list = new ArrayList<>();
		List<TeacherCourse> teacherCourses = teacherCourseRepository.findAllByTeacherId(tId);
		for (TeacherCourse teacherCourse : teacherCourses) {
			TeacherCourseDto teacherCourseDto = new TeacherCourseDto(teacherCourse);
			list.add(teacherCourseDto);
		}
		if("desc".equals(dir)) {
			Collections.sort(list, new Comparator<TeacherCourseDto>() {
	
				@Override
				public int compare(TeacherCourseDto o1, TeacherCourseDto o2) {
					// TODO Auto-generated method stub
					return Integer.valueOf(o2.getCourseId())-Integer.valueOf(o1.getCourseId());
				}
			});
			
		}
		return list;
	}
	
	@Override
	public List<StudentCourseDto> getStudentList(String id, String dir) {
		// TODO Auto-generated method stub
		List<StudentCourse> stuCourseList = new ArrayList<>();
		List<StudentCourseDto> stuCourseDtoList = new ArrayList<>();
		stuCourseList = studentCourseRepository.findBycourseId(id);
		for (StudentCourse studentCourse : stuCourseList) {
			LOG.info("11111111--"+studentCourse);
			StudentCourseDto courseDto = new StudentCourseDto(studentCourse);
			stuCourseDtoList.add(courseDto);
		}
		if("desc".equals(dir)) {
			Collections.sort(stuCourseDtoList, new Comparator<StudentCourseDto>() {

				@Override
				public int compare(StudentCourseDto o1, StudentCourseDto o2) {
					// TODO Auto-generated method stub
					return Integer.valueOf(o2.getStudentId())-Integer.valueOf(o1.getStudentId());
				}
			});
			
		}
		return stuCourseDtoList;
	}
	
	@Override
	public void createTeacher(TeacherDto dto) {
		// TODO Auto-generated method stub
		Teacher po = dto.createPo();
		teacherRepository.save(po);
	}
	@Override
	public TeacherDto findById(String id) {
		Teacher po = teacherRepository.findById(id).get();
		return new TeacherDto(po);
	}
	@Override
	public void updateTeacher(TeacherDto dto) {
		Teacher po = teacherRepository.findById(dto.getJobNo()).get();
		dto.updatePo(po);
		teacherRepository.save(po);
	}
	@Override
	public void deleteTeacher(String[] id) {
		teacherRepository.deleteByJobNoIn(id);
	}

	@Override
	public List<CourseTableDto> getTeacherListBySemester(String tId, String sid) {
		List<CourseTableDto> list = new ArrayList<>();
		List<CourseTable> teacherCourses = courseTableRepository.findAllByCourseTableTeacherId(tId, sid);
		for (CourseTable courseTable : teacherCourses) {
			LOG.info(courseTable);
			CourseTableDto dto = new CourseTableDto(courseTable);
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<Teacher> getAllByCollegeId(String collegeId) {
		List<Teacher> teachers = teacherRepository.findAllByCollegeId(collegeId);
		return teachers;
	}
	@Override
	public List<String> getAllJobNoByCollegeId(String collegeId) {
		List<String> jobNoes = teacherRepository.findAllJobNoByCollegeId(collegeId);
		return jobNoes;
	}
}
