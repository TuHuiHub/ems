package com.dream.ems.service;


import java.util.List;

import com.dream.ems.dto.StudentDto;

import wo.common.entity.WoPage;

public interface StudentService {

	WoPage<StudentDto> getPageData(Long start, Long length, String searchContent, String dir);

	void createStudent(StudentDto dto);

	StudentDto findById(String id);

	void updateStudent(StudentDto dto);

	void deleteStudent(String[] id);


	StudentDto getStudent(String id);

	List<StudentDto> getAll();

    List<StudentDto> findAllByClazzId(String id, String dir);
}
