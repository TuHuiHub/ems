package com.dream.ems.service;


import java.util.List;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.dto.TeacherCourseDto;

import com.dream.ems.dto.TeacherDto;
import com.dream.ems.po.Teacher;

import wo.common.entity.WoPage;

public interface TeacherService {

	WoPage<TeacherDto> getPageData(Long start, Long length, String searchContent, String dir);

	TeacherDto getTeacher(String userId);
	
	List<TeacherCourseDto> getTeacherList(String tId, String dir);

	List<StudentCourseDto> getStudentList(String id, String dir);
	
	void createTeacher(TeacherDto dto);

	TeacherDto findById(String id);

	void updateTeacher(TeacherDto dto);

	void deleteTeacher(String[] id);

	List<Teacher> getAllByCollegeId(String collegeId);

	List<CourseTableDto> getTeacherListBySemester(String tId, String sid);

	List<String> getAllJobNoByCollegeId(String collegeId);

}
