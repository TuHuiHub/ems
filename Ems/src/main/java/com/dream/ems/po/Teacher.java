package com.dream.ems.po;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import wo.bsys.po.User;
/**
 * 老师
 * @author Ylinx
 * @date 2018年12月3日
 */
@Entity
@Table(name="t_teacher")
public class Teacher {

	
	@Id
	@Column(length=20)
	private String jobNo;
	
	@Column(length=50)
	private String name;
	
	@Column(length=10)
	private String sex;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(length=20)
	private String degree;		//学历
	
	@Column(length=20)			//头衔
	private String title;
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private College college;//学员
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="teacher_user_fk")
	private User user;

	@OneToMany(mappedBy="teacher")
	private List<TeacherCourse> TeacherCourse;	//已选课程
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String jobNo, String name, String sex, Date birthday, String degree, String title, College college,
			User user, List<com.dream.ems.po.TeacherCourse> teacherCourse) {
		super();
		this.jobNo = jobNo;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.degree = degree;
		this.title = title;
		this.college = college;
		this.user = user;
		this.TeacherCourse = teacherCourse;
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
	public Date getBirthday() {
		return birthday;
	}
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
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<TeacherCourse> getTeacherCourse() {
		return TeacherCourse;
	}
	public void setTeacherCourse(List<TeacherCourse> teacherCourse) {
		TeacherCourse = teacherCourse;
	}
	@Override
	public String toString() {
		return "Teacher [jobNo=" + jobNo + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", degree="
				+ degree + ", title=" + title + ", college=" + college + ", user=" + user + "]";
	}


}	
