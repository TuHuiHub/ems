package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;

import com.dream.ems.po.Admin;
import com.fasterxml.jackson.annotation.JsonFormat;

import wo.bsys.po.Role;
import wo.bsys.po.User;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;


public class AdminDto {

	private String jobNo;
	
	private String name;
	
	private String sex;
	
	private Date birthDay;
	
	private String userId;
	
	private String userLoginName;
	
	private String userPassword="123456";
	
	private String roleId;

	public AdminDto(String jobNo, String name, String sex, Date birthDay, String userId, String userLoginName,
			String userPassword) {
		super();
		this.jobNo = jobNo;
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userPassword = userPassword;
	}

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getBirthDay() {
		return birthDay;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		if(!WoUtil.isEmpty(userPassword)){
			this.userPassword = userPassword;
		}
		
	}
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public AdminDto(Admin po) {
		this.setJobNo(po.getJobNo());
		this.setName(po.getName());
		this.setSex(po.getSex());
		this.setBirthDay(po.getBirthDay());
		if(!WoUtil.isEmpty(po.getUser())){
			this.setUserId(po.getUser().getId());
			this.setUserLoginName(po.getUser().getLoginName());
			this.setUserPassword(po.getUser().getPassword());
		}
	
	}
	
	public Admin createPo() {
		Admin po = new Admin();
		po.setJobNo(this.getJobNo());
		po.setName(this.getName());
		po.setSex(this.getSex());
		po.setBirthDay(this.getBirthDay());
		User user = new User();
		user.setId(this.getJobNo());
		user.setLoginName(this.getJobNo());
		user.setPassword(WoUtil.getMD5(jobNo, userPassword));
		user.setCreateTime(new Date());
		Role r = new Role();
		r.setId(roleId);
		user.setRoles(Arrays.asList(r));
		po.setUser(user);
		return po;
	}
	
	public void updatePo(Admin po) {
		po.setName(this.getName());
		po.setSex(this.getSex());
		po.setBirthDay(this.getBirthDay());
		if(!WoUtil.isEmpty(po.getUser())){
			if(!po.getUser().getPassword().equals(this.userPassword)&&!WoUtil.isEmpty(userPassword)){
				po.getUser().setPassword(WoUtil.getMD5(jobNo, userPassword));
				po.getUser().setPasswordTime(new Date());
			}
			
		}
	}
	
	public static WoPage<AdminDto> getPageData(List<Admin> content, Long totalElements) {
		List<AdminDto> dtos = new ArrayList<AdminDto>();
		for (Admin po : content) {
			dtos.add(new AdminDto (po));
		}
		return new WoPage<AdminDto>(dtos, totalElements);
	}

	@Override
	public String toString() {
		return "AdminDto [jobNo=" + jobNo + ", name=" + name + ", sex=" + sex + ", birthDay=" + birthDay + ", userId="
				+ userId + ", userLoginName=" + userLoginName + ", userPassword=" + userPassword + ", roleId=" + roleId
				+ "]";
	}
	
}
