package com.dream.ems.service.impl;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dream.ems.dto.OperationLogDto;
import com.dream.ems.po.OperationLog;
import com.dream.ems.repository.OperationLogRepository;
import com.dream.ems.service.OperationLogService;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;
@Service
@Transactional(TxType.REQUIRES_NEW)
public class OperationLogServiceImpl implements OperationLogService {
	@Resource
	private OperationLogRepository operationLogRepository;
	@Override
	public void save(OperationLog log) {
		operationLogRepository.save(log);
	}
	@Override
	public WoPage<OperationLogDto> getPageData(Long start, Long length, String searchContent, String dir) {
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<OperationLog> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = operationLogRepository.findAll(pageInput);
		} else {
			pageData = operationLogRepository.findAllByMethodLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<OperationLogDto> pr = OperationLogDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}
}
