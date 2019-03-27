package com.dream.ems.vo;

import java.util.ArrayList;
import java.util.List;

import com.dream.ems.dto.CourseDto;
import com.dream.ems.po.Course;

public class CourseVo {
	
	private String id;
	
	private String name;

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
	
	public CourseVo(Object o){
		if(o instanceof Course){
			Course c = (Course)o;
			this.id = c.getId();
			this.name = c.getName();
			
		}else if(o instanceof CourseDto){
			CourseDto dto = (CourseDto)o;
			this.id = dto.getId();
			this.name = dto.getName();
		}
	}
	
	public static List<CourseVo> getVos(List<Course> pos){
		List<CourseVo> vos  = new ArrayList<>();
		for (Course c : pos) {
			CourseVo vo = new CourseVo(c);
			vos.add(vo);
		}
		return vos;
	}
	
}
