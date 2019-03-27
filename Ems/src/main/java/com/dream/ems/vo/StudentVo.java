package com.dream.ems.vo;

import java.text.SimpleDateFormat;
import java.util.List;


import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.dto.StudentDto;


public class StudentVo {


	private String stuNo; 			//学号

	private String name;			//姓名

	private String birthday;			//生日

	private String sex;				//性别

	private String grade;				//入学时间

	private String collegeId;		//所属学院

	private String collegeName;		//所属学院

	private String majorId;			//所属专业

	private String majorName;			//所属专业

	private List<StudentCourseDto> studentCourses;	//已选课程

	private String userId;

	private String userName;

	private String userPassword;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	public StudentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentVo(String stuNo, String name, String birthday, String sex, String grade, String collegeId,
			String collegeName, String majorId, String majorName, List<StudentCourseDto> studentCourses, String userId,
			String userName, String userPassword) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.grade = grade;
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.majorId = majorId;
		this.majorName = majorName;
		this.studentCourses = studentCourses;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public StudentVo(StudentDto po) {
		this.stuNo = po.getStuNo();
		this.name = po.getName();
		this.birthday =sdf.format( po.getBirthday());
		this.sex = po.getSex();
		this.grade =  sdf.format( po.getGrade());
		this.collegeId = po.getCollegeId();
		this.collegeName = po.getCollegeName();
		this.majorId = po.getMajorId();
		this.majorName = po.getMajorName();
		this.userId = po.getUserId();
		this.userName = po.getUserName();
		this.userPassword = po.getUserPassword();
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public List<StudentCourseDto> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourseDto> studentCourses) {
		this.studentCourses = studentCourses;
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
		this.userPassword = userPassword;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}


}
