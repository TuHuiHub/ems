package com.dream.ems.service;

import java.util.List;
import java.util.Map;

import com.dream.ems.dto.StudentCourseDto;

public interface StudentCourseService {

	List<StudentCourseDto> getStudentList(String sId);

	int chooseCourse(String id, Map<String, Object> map);


}
