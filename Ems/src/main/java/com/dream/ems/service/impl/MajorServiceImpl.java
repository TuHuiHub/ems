package com.dream.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.dream.ems.dto.CollegeDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.po.College;
import com.dream.ems.po.Major;
import com.dream.ems.repository.CourseTableRepository;
import com.dream.ems.repository.MajorRepository;
import com.dream.ems.service.MajorService;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class MajorServiceImpl implements MajorService {

	
	@Resource
	private MajorRepository majorRepository;
	@Resource
	private CourseTableRepository courseTableRepository;
	
	@Override
	public List<Major> getMajorsByCollegeId(String collegeId) {
		List<Major> majors = majorRepository.findAllByCollege_id(collegeId);
		
		return majors;
	}
	
	@Override
	public WoPage<MajorDto> getPageData(CollegeDto dto, Long start, Long length, String searchContent, String dir) {
		ExampleMatcher m = ExampleMatcher.matching();
		Major qo = new Major();
		if(!WoUtil.isEmpty(searchContent)) {
			m.withMatcher("name", GenericPropertyMatchers.contains());
			qo.setName(searchContent);
		}
		if(!WoUtil.isEmpty(dto.getId())){
			m.withMatcher("college.id", GenericPropertyMatchers.exact());
			College c = new College();
			c.setId(dto.getId());
			qo.setCollege(c);
		}
		Example<Major> major = Example.of(qo, m);
		Pageable p = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		Page<Major> page = majorRepository.findAll(major, p);
		return new WoPage<MajorDto> (MajorDto.getDtos(page.getContent()), page.getTotalElements());
	}
	
	@Override
	public void create(MajorDto dto) {
		Major major = dto.createPO ();
		majorRepository.save(major);
	}
	
	@Override
	public MajorDto getById(String id) {
		Major po = this.majorRepository.findById(id).get();
		return new MajorDto (po);
	}
	
	@Override
	public void update(MajorDto dto) {
		Major po = majorRepository.findById(dto.getId()).get();
		dto.update(po);
		majorRepository.save(po);
	}
	
	@Override
	public void delete(String[] id) {
		majorRepository.deleteByIdIn(id);
	}

	@Override
	public Major getMajor(String majorId) {
		return majorRepository.findById(majorId).get();
	}

	@Override
	public WoPage<MajorDto> getPageData(Long start, Long length, String searchContent, String dir, String params) {
		ExampleMatcher m = ExampleMatcher.matching();
		Major qo = new Major();
		if(!WoUtil.isEmpty(searchContent)) {
			m.withMatcher("name", GenericPropertyMatchers.contains());
			qo.setName(searchContent);
		}
		if(!WoUtil.isEmpty(params)){
			m.withMatcher("college.id", GenericPropertyMatchers.exact());
			College c = new College();
			c.setId(params);
			qo.setCollege(c);
		}
		Example<Major> major = Example.of(qo, m);
		Pageable p = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		Page<Major> page = majorRepository.findAll(major, p);
		return new WoPage<MajorDto> (MajorDto.getDtos(page.getContent()), page.getTotalElements());
	}

	@Override
	public WoPage<MajorDto> getCourseTableData(Long start, Long length, String searchContent, String dir) {
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<Major> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = majorRepository.findAll(pageInput);
		} else {
			pageData = majorRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		List<MajorDto> dtos = new ArrayList<>();
		List<Major> pos = pageData.getContent();
		for (Major po : pos) {
			MajorDto dto = new MajorDto(po);
			List<Integer> ctpoids = courseTableRepository.findIdByMajorId(po.getId());
			if(ctpoids.size()>0){
				dto.setIsCourseSelected("是");
				dto.setCourseTableIds(ctpoids);
			}
			dtos.add(dto);
		}
		return new WoPage<MajorDto> (dtos, pageData.getTotalElements());
	}

}
