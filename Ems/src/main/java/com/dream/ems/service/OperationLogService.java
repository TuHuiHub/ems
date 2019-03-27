package com.dream.ems.service;

import com.dream.ems.dto.OperationLogDto;
import com.dream.ems.po.OperationLog;

import wo.common.entity.WoPage;

public interface OperationLogService {
	
	void save(OperationLog log);

	WoPage<OperationLogDto> getPageData(Long start, Long length, String searchContent, String dir);
}
