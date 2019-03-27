package com.dream.ems.service;

import java.util.List;
import java.util.Map;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.po.CourseTable;

import wo.common.entity.WoPage;

public interface CourseTableService {

	List<CourseTableDto> getByMid(String majorId);

	Integer getStuNumberByCtId(Integer id);

	List<CourseTableDto> getCourseTable(String collegeId, String majorId);

	void deleteByIdIn(List<Integer> courseTableIds);

	void saveCourseTables(List<CourseTable> pos);

	void deleteByMajorId(String majorId);

	CourseTableDto getTableByid(Integer id);

	void saveElectiveCoursePlan(CourseTableDto data);
	WoPage<CourseTableDto> getAllMyDataTable(Long start, Long length, String searchContent, String dir, String studentId);

	WoPage<CourseTableDto> getPageData(String param, Long start, Long length, String searchContent, String dir);

	CourseTableDto findById(String id);

	void updateCourseTable(CourseTableDto dto);

	void deleteCourseTable(String[] id);

	List<CourseTable> getAllByTeacherJobNo(List<String> jobNoes);

    List<CourseTableDto> findAllByCourseAndTeacher(String id, String jobNo);

    List<CourseTableDto> findAllByClazz(String stuNo, String semesterId);
}
