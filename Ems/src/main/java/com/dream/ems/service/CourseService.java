package com.dream.ems.service;
import java.util.List;
import java.util.Map;


import com.dream.ems.dto.CourseDto;
import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.po.Course;
import com.dream.ems.vo.SelectCourseData;

import wo.common.entity.WoPage;

public interface CourseService {

	WoPage<CourseDto> getPageData(MajorDto dto, Long start, Long length, String searchContent, String dir);

	void create(CourseDto dto);

	CourseDto getById(String id);

	void update(CourseDto dto);

	void delete(String[] id);

	WoPage<CourseDto> getPageData(Long start, Long length, String searchContent, String dir);

	Map<String, Object> selectCourse(CourseTableDto dto);

	List<Course> getAllByMajorId(String majorId);

	WoPage<CourseDto> getAllDataTable(Long start, Long length, String searchContent, String dir);

    List<Course> getAllByMajorIdAndSemesterId(String majorId, String semesterId);
}
