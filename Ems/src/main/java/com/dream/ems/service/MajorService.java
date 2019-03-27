package com.dream.ems.service;

import java.util.List;


import com.dream.ems.dto.CollegeDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.po.Major;

import wo.common.entity.WoPage;

public interface MajorService {

	List<Major> getMajorsByCollegeId(String collegeId);

	WoPage<MajorDto> getPageData(CollegeDto dto, Long start, Long length, String searchContent, String dir);

	void create(MajorDto dto);

	MajorDto getById(String id);

	void update(MajorDto dto);

	void delete(String[] id);

	Major getMajor(String majorId);

	WoPage<MajorDto> getPageData(Long start, Long length, String searchContent, String dir, String params);

	WoPage<MajorDto> getCourseTableData(Long start, Long length, String searchContent, String dir);

}
