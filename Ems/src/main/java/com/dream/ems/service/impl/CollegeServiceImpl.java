package com.dream.ems.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dream.ems.dto.CollegeDto;
import com.dream.ems.po.College;
import com.dream.ems.repository.CollegeRepositiry;
import com.dream.ems.service.CollegeService;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {

	
	@Resource
	private CollegeRepositiry collegeRepository;
	
	@Override
	public List<College> getAllCollege() {
		List<College> colleges = collegeRepository.findAll();
		return colleges;
	}
	
	@Override
	public WoPage<CollegeDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 构造分页参数
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<College> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = collegeRepository.findAll(pageInput);
		} else {
			pageData = collegeRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<CollegeDto> pr = CollegeDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}
	
	@Override
	public void create(CollegeDto dto) {
		College college = dto.createPO();
		collegeRepository.save(college);
	}
	
	@Override
	public CollegeDto getById(String id) {
		College po = this.collegeRepository.findById(id).get();
		return new CollegeDto (po);
	}
	
	@Override
	public void update(CollegeDto dto) {
		College po = this.collegeRepository.findById(dto.getId()).get();
		dto.updatePO(po);
		this.collegeRepository.save(po);
	}
	
	@Override
	public void delete(String[] id) {
		collegeRepository.deleteByIdIn(id);
	}

	@Override
	public College getCollege(String collegeId) {
		return collegeRepository.findById(collegeId).get();
	}

}
