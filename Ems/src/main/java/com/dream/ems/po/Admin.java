package com.dream.ems.po;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import wo.bsys.po.User;

@Entity
@Table(name="t_admin")
public class Admin {
	
	@Id
	@Column(length=20)
	private String jobNo;
	
	@Column(length=20)
	private String name;
	
	@Column(length=50)
	private String sex;
	
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="admin_user_fk")
	private User user;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String jobNo, String name, String sex, Date birthDay, User user) {
		super();
		this.jobNo = jobNo;
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.user = user;
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
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Admin [jobNo=" + jobNo + ", name=" + name + ", sex=" + sex + ", birthDay=" + birthDay + ", user=" + user
				+ "]";
	}
	

	
}
