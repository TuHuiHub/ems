package com.dream.ems.service;


import com.dream.ems.dto.AdminDto;

import wo.common.entity.WoPage;

public interface AdminService {

	WoPage<AdminDto> getPageData(Long start, Long length, String searchContent, String dir);

	void createAdmin(AdminDto dto);

	AdminDto findById(String id);

	void updateAdmin(AdminDto dto);

	void delete(String[] id);


}
