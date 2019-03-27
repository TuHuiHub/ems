package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.dream.ems.po.Clazz;
import com.dream.ems.po.College;
import com.dream.ems.po.Major;
import com.dream.ems.po.Student;
import com.fasterxml.jackson.annotation.JsonFormat;

import wo.bsys.po.Role;
import wo.bsys.po.User;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

public class StudentDto {


	private String stuNo; // 学号

	private String name; // 姓名

	private Date birthday; // 生日

	private String sex; // 性别

	private Date grade; // 入学时间

	private String collegeId; // 所属学院

	private String collegeName; // 所属学院

	private String majorId; // 所属专业

	private String majorName; // 所属专业
	
	private String clazzId;//所属班级
	private String clazzName;
	

	public String getClazzId() {
		return clazzId;
	}

	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}

	public String getClazzName() {
		return clazzName;
	}


	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}


	private List<StudentCourseDto> studentCourses; // 已选课程

	private String userId;

	private String loginName;
	
	private double score; 
	
	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	private String userName;

	private String userPassword="123456";
	
	private String roleId;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String stuNo, String name, Date birthday, String sex, Date grade, String collegeId,
			String collegeName, String majorId, String majorName, String clazzId, String clazzName,
			List<StudentCourseDto> studentCourses, String userId, String loginName, double score, String userName,
			String userPassword, String roleId) {
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
		this.clazzId = clazzId;
		this.clazzName = clazzName;
		this.studentCourses = studentCourses;
		this.userId = userId;
		this.loginName = loginName;
		this.score = score;
		this.userName = userName;
		this.userPassword = userPassword;
		this.roleId = roleId;
	}

	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	public StudentDto(Student po) {
		this.stuNo = po.getStuNo();
		this.name = po.getName();
		this.birthday = po.getBirthday();
		this.sex = po.getSex();
		this.grade = po.getGrade();
		if (!WoUtil.isEmpty(po.getCollege())) {
			this.collegeId = po.getCollege().getId();
			this.collegeName = po.getCollege().getName();
		}
		if (!WoUtil.isEmpty(po.getMajor())) {
			this.majorId = po.getMajor().getId();
			this.majorName = po.getMajor().getName();
		}
		if(!WoUtil.isEmpty(po.getClazz())) {
			this.clazzId = po.getClazz().getId();
			this.clazzName = po.getClazz().getClazzName();
		}
//		this.studentCourses = CourseDto.getDtosSC(po.getStudentCourses());
		if (!WoUtil.isEmpty(po.getUser())) {
			this.userId = po.getUser().getId();
			this.loginName = po.getUser().getLoginName();
			this.userName = po.getUser().getLoginName();
			this.userPassword = po.getUser().getPassword();
		}

	}

	public Student createPo() {
		Student po = new Student();
		po.setStuNo(stuNo);
		po.setName(name);
		po.setGrade(grade);
		po.setSex(sex);
		po.setBirthday(birthday);
		if (!WoUtil.isEmpty(collegeId)) {
			College college = new College();
			college.setId(collegeId);
			college.setName(collegeName);
			po.setCollege(college);
		}
		if (!WoUtil.isEmpty(majorId)) {
			Major major = new Major();
			major.setId(majorId);
			major.setName(majorName);
			po.setMajor(major);
		}
		if (!WoUtil.isEmpty(clazzId)) {
			Clazz clazz = new Clazz();
			clazz.setId(clazzId);
			clazz.setClazzName(clazzName);
			po.setClazz(clazz);
		}

		User user = new User();
		user.setId(stuNo);
		user.setLoginName(stuNo);
		user.setPassword(WoUtil.getMD5(stuNo, userPassword));
		user.setCreateTime(new Date());
		user.setPasswordTime(new Date());
		Role r = new Role();
		r.setId(roleId);
		user.setRoles(Arrays.asList(r));
		po.setUser(user);
		return po;
	}

	public void updatePo(Student po) {
		po.setName(name);
		po.setGrade(grade);
		po.setSex(sex);
		po.setBirthday(birthday);
		if (!WoUtil.isEmpty(collegeId)) {
			College college = new College();
			college.setId(collegeId);
			po.setCollege(college);
		} else {
			po.setCollege(null);
		}
		if (!WoUtil.isEmpty(majorId)) {
			Major major = new Major();
			major.setId(majorId);
			po.setMajor(major);
		} else {
			po.setMajor(null);
		}
		if (!WoUtil.isEmpty(clazzId)) {
			Clazz clazz = new Clazz();
			clazz.setId(clazzId);
			po.setClazz(clazz);
		} else {
			po.setClazz(null);
		}
		if(!WoUtil.isEmpty(po.getUser())){
			if(!po.getUser().getPassword().equals(this.userPassword)&&!WoUtil.isEmpty(userPassword)){
				po.getUser().setPassword(WoUtil.getMD5(stuNo, userPassword));
				po.getUser().setPasswordTime(new Date());
			}
		}
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
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		if(!WoUtil.isEmpty(userPassword)){
			this.userPassword = userPassword;
		}
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getGrade() {
		return grade;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setGrade(Date grade) {
		this.grade = grade;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public static WoPage<StudentDto> getPageData(List<Student> content, Long totalElements) {
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		for (Student po : content) {
			dtos.add(new StudentDto(po));
		}
		return new WoPage<StudentDto>(dtos, totalElements);
	}
	public static List<StudentDto> getDtos(List<Student> pos){
		ArrayList<StudentDto> dtos = new ArrayList<>();
		for (Student s : pos) {
			StudentDto dto = new StudentDto(s);
			dtos.add(dto);
		}
		return dtos;
	}
}
