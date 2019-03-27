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
 * 学生
 * @author Ylinx
 * @date 2018年12月3日
 */
@Entity
@Table(name="t_student")
public class Student {

	
	@Id
	@Column(length=20)
	private String stuNo; 			//学号

	@Column(length=50)
	private String name;			//姓名
	
	@Temporal(TemporalType.DATE)
	private Date birthday;			//生日
	
	@Column(length=10)
	private String sex;				//性别
	
	@Temporal(TemporalType.DATE)
	private Date grade;				//入学时间
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private College college;		//所属学院
	
	@ManyToOne
	@JoinColumn(name="major_id")
	private Major major;			//所属专业
	
	@OneToMany(mappedBy="student")
	private List<StudentCourse> studentCourses;	//已选课程
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_user_fk")
	private User user;				//用户
	
	@ManyToOne
	@JoinColumn(name="clazz_id")
	private Clazz clazz;//班级
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getGrade() {
		return grade;
	}

	public void setGrade(Date grade) {
		this.grade = grade;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Student(String stuNo, String name, Date birthday, String sex, Date grade, College college, Major major,
			List<StudentCourse> studentCourses, User user, Clazz clazz) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.grade = grade;
		this.college = college;
		this.major = major;
		this.studentCourses = studentCourses;
		this.user = user;
		this.clazz = clazz;
	}

}
