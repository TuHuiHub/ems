package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;


import com.dream.ems.po.College;
import com.dream.ems.po.Major;

import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

public class MajorDto {

	
	private String id;
	
	private String name;
	
	private String eduSys;		//学制
	
	private String collegeId;
	
	private String collegeName;

	private List<Integer> courseTableIds;
	
	private String isCourseSelected = "否";
	
	public MajorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MajorDto(String id, String name, String eduSys, String collegeId, String collegeName) {
		super();
		this.id = id;
		this.name = name;
		this.eduSys = eduSys;
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}
	
	public MajorDto(Major po) {
		this.id = po.getId();
		this.name = po.getName();
		this.eduSys = po.getEduSys();
		if (!WoUtil.isEmpty(po.getCollege())) {
			this.collegeId = po.getCollege().getId();
			this.collegeName = po.getCollege().getName();
		}
	}
	
	public static WoPage<MajorDto> getPageData(List<Major> content, Long totalElements) {
		List<MajorDto> dtos = new ArrayList<MajorDto>();
		for (Major po : content) {
			dtos.add(new MajorDto (po));
		}
		return new WoPage<MajorDto>(dtos, totalElements);
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

	public String getEduSys() {
		return eduSys;
	}

	public void setEduSys(String eduSys) {
		this.eduSys = eduSys;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}




	public List<Integer> getCourseTableIds() {
		return courseTableIds;
	}

	public void setCourseTableIds(List<Integer> courseTableIds) {
		this.courseTableIds = courseTableIds;
	}

	public String getIsCourseSelected() {
		return isCourseSelected;
	}

	public void setIsCourseSelected(String isCourseSelected) {
		this.isCourseSelected = isCourseSelected;
	}

	@Override
	public String toString() {
		return "MajorDto [id=" + id + ", name=" + name + ", eduSys=" + eduSys + ", collegeId=" + collegeId
				+ ", collegeName=" + collegeName + "]";
	}

//	public static WoPage<MajorDto> getDtos(List<Major> content, long totalElements) {
//		List<MajorDto> dtos = new ArrayList<MajorDto>();
//		for (Major po : content) {
//			dtos.add(new MajorDto(po));
//		}
//		return new WoPage<MajorDto>(dtos, totalElements);
//	}

	public static List<MajorDto> getDtos(List<Major> content) {
		List<MajorDto> dtos = new ArrayList<MajorDto>();
		for (Major po : content) {
			dtos.add(new MajorDto(po));
		}
		return dtos;
	}	

	public void update(Major po) {
		po.setId(id);
		po.setName(name);
		po.setEduSys(eduSys);
	}

	public Major createPO() {
		Major po = new Major();
		po.setId(id);
		po.setName(name);
		po.setEduSys(eduSys);
		if (!WoUtil.isEmpty(collegeId)) {
			College college = new College();
			college.setId(collegeId);
			po.setCollege(college);
		}
		return po;
	}
	
	
}
