package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.dream.ems.po.College;
import com.dream.ems.po.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;

import wo.bsys.po.Role;
import wo.bsys.po.User;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

public class TeacherDto {

	private static Logger LOG = LogManager.getLogger(TeacherDto.class);
	private String jobNo;
	
	private String name;
	
	private String sex;
	
	private Date birthday;
	
	private String degree;		//学历
	
	private String title;
	
	private String collegeId;
	
	private String collegeName;

	private List<TeacherCourseDto> TeacherCourse;	//已选课程
	
	private String userId;
	
	private String userName;
	
	private String userPassword="123456";
	
	private String roleId;

	public TeacherDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getRoleId() {
		return roleId;
	}



	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}



	public static Logger getLOG() {
		return LOG;
	}

	public static void setLOG(Logger lOG) {
		LOG = lOG;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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



	public List<TeacherCourseDto> getTeacherCourse() {
		return TeacherCourse;
	}



	public void setTeacherCourse(List<TeacherCourseDto> teacherCourse) {
		TeacherCourse = teacherCourse;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		if(!WoUtil.isEmpty(userPassword)){
			this.userPassword = userPassword;
		}
	}

	
	public TeacherDto(Teacher po){
		this.jobNo = po.getJobNo();
		this.name = po.getName();
		this.sex = po.getSex();
		this.birthday = po.getBirthday();
		this.degree = po.getDegree();
		this.title = po.getTitle();
		if(!WoUtil.isEmpty(po.getCollege())){
			this.collegeId = po.getCollege().getId();
			this.collegeName = po.getCollege().getName();
		}
		
		if(!WoUtil.isEmpty(po.getUser())){
			this.userId = po.getUser().getId();
			this.userName = po.getUser().getLoginName();
			this.userPassword = po.getUser().getPassword();
		}
		this.TeacherCourse = CourseDto.getDtosTC(po.getTeacherCourse());
	}
	
	public Teacher createPo() {
		Teacher po = new Teacher();
		po.setJobNo(this.jobNo);
		po.setName(this.name);
		po.setSex(this.sex);
		po.setBirthday(this.birthday);
		po.setDegree(this.degree);
		po.setTitle(this.title);
		
		User u = new User();
		u.setId(this.jobNo);
		u.setLoginName(this.jobNo);
		u.setPassword(WoUtil.getMD5(jobNo, userPassword));
		u.setCreateTime(new Date());
		u.setPasswordTime(new Date());
		Role r = new Role();
		r.setId(roleId);
		u.setRoles(Arrays.asList(r));
		po.setUser(u);
		College c = new College();
		c.setId(this.collegeId);
		po.setCollege(c);
		return po;
		
	}
	
	public void updatePo(Teacher po) {
		po.setName(this.name);
		po.setSex(this.sex);
		po.setBirthday(this.birthday);
		po.setDegree(this.degree);
		po.setTitle(this.title);
		if(!WoUtil.isEmpty(po.getUser())){
			if(!po.getUser().getPassword().equals(this.userPassword)&&!WoUtil.isEmpty(this.userPassword)){
				po.getUser().setPassword(WoUtil.getMD5(jobNo, userPassword));
				po.getUser().setPasswordTime(new Date());
			}
			
		}
		if(!WoUtil.isEmpty(collegeId)){
			College c = new College();
			c.setId(this.collegeId);
			po.setCollege(c);
		}
		
	}
	
	public static WoPage<TeacherDto> getPageData(List<Teacher> content, Long totalElements) {
		List<TeacherDto> dtos = new ArrayList<TeacherDto>();
		for (Teacher po : content) {
			dtos.add(new TeacherDto (po));
		}
		return new WoPage<TeacherDto>(dtos, totalElements);
	}

	public static List<TeacherDto> getDtos(List<Teacher> pos){
		List<TeacherDto> dtos = new ArrayList<>();
		for (Teacher teacher : pos) {
			TeacherDto dto = new TeacherDto(teacher);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String toString() {
		return "TeacherDto [jobNo=" + jobNo + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", degree="
				+ degree + ", title=" + title + ", collegeId=" + collegeId + ", collegeName=" + collegeName
				+ ", TeacherCourse=" + TeacherCourse + ", userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + "]";
	}
	
}
