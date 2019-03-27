package com.dream.ems.service;

import java.util.List;


import com.dream.ems.dto.CollegeDto;
import com.dream.ems.po.College;

import wo.common.entity.WoPage;

public interface CollegeService {

	List<College> getAllCollege();

	WoPage<CollegeDto> getPageData(Long start, Long length, String searchContent, String dir);

	void create(CollegeDto dto);

	CollegeDto getById(String id);

	void update(CollegeDto dto);

	void delete(String[] id);

	College getCollege(String collegeId);

}
