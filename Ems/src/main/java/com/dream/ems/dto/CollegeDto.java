package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;

import com.dream.ems.po.College;

import wo.common.entity.WoPage;

public class CollegeDto {


	private String id;
	
	private String name;

	public CollegeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollegeDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CollegeDto(College po) {
		this.id = po.getId();
		this.name = po.getName();
	}
	
	public College createPo() {
		College po = new College();
		po.setId(id);
		po.setName(name);
		return po;
	}
	
	public void updatePo(College po) {
		po.setId(id);
		po.setName(name);
	}
	
	public static WoPage<CollegeDto> getPageData(List<College> content, Long totalElements) {
		List<CollegeDto> dtos = new ArrayList<CollegeDto>();
		for (College po : content) {
			dtos.add(new CollegeDto (po));
		}
		return new WoPage<CollegeDto>(dtos, totalElements);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CollegeDto [id=" + id + ", name=" + name + "]";
	}

	public College createPO() {
		College po = new College();
		po.setId(id);
		po.setName(name);
		return po;
	}

	public void updatePO(College po) {
		po.setId(id);
		po.setName(name);
	}
	
	
	

}
