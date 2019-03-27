package com.dream.ems.service.impl;


import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.dream.ems.dto.AdminDto;
import com.dream.ems.po.Admin;
import com.dream.ems.repository.AdminRepository;
import com.dream.ems.service.AdminService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	private static Logger LOG = LogManager.getLogger(AdminServiceImpl.class);
	@Resource
	private AdminRepository adminRepository;
	@Override
	public WoPage<AdminDto> getPageData(Long start, Long length, String searchContent, String dir) {
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<Admin> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = adminRepository.findAll(pageInput);
		} else {
			pageData = adminRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<AdminDto> pr = AdminDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}
	@Override
	public void createAdmin(AdminDto dto) {
		Admin po = dto.createPo();
		adminRepository.save(po);
	}
	@Override
	public AdminDto findById(String id) {
		Admin po = adminRepository.findById(id).get();
		AdminDto dto = new AdminDto(po);
		return dto;
	}
	@Override
	public void updateAdmin(AdminDto dto) {
		Admin po = adminRepository.findById(dto.getJobNo()).get();
		dto.updatePo(po);
		LOG.info(po);
		adminRepository.save(po);
	}
	@Override
	public void delete(String[] id) {
		adminRepository.deleteByJobNoIn(id);
	}

}
