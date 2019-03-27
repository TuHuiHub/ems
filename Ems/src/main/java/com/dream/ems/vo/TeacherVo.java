package com.dream.ems.vo;
import java.util.ArrayList;
import java.util.List;


import com.dream.ems.dto.TeacherDto;
import com.dream.ems.po.Teacher;

public class TeacherVo {
	private String jobNo;
	
	private String name;

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public TeacherVo(Object o){
		if(o instanceof Teacher){
			Teacher c = (Teacher)o;
			this.jobNo = c.getJobNo();
			this.name = c.getName();
			
		}else if(o instanceof TeacherDto){
			TeacherDto dto = (TeacherDto)o;
			this.jobNo = dto.getJobNo();
			this.name = dto.getName();
		}
	}
	
	public static List<TeacherVo> getVos(List<Teacher> pos){
		List<TeacherVo> vos  = new ArrayList<>();
		for (Teacher t : pos) {
			TeacherVo vo = new TeacherVo(t);
			vos.add(vo);
		}
		return vos;
	}
}
