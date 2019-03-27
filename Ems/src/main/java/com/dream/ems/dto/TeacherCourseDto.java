package com.dream.ems.dto;

import com.dream.ems.po.Course;
import com.dream.ems.po.Teacher;
import com.dream.ems.po.TeacherCourse;

import wo.common.util.WoUtil;

public class TeacherCourseDto {
	

	private String id;
	
	private String teacherId;
	
	private String teacherName;
	
	private String courseId;

	private String courseName;
	
	private String classRoom;
	


	public TeacherCourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TeacherCourseDto(String id, String teacherId, String teacherName, String courseId, String courseName,
			String classRoom) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.classRoom = classRoom;
	}



	public TeacherCourseDto(TeacherCourse r) {
		this.id = r.getId();
		if (r.getTeacher()!=null) {
			this.teacherId = r.getTeacher().getJobNo();
			this.teacherName = r.getTeacher().getName();
		}
		if (r.getCourse()!=null) {
			this.courseId = r.getCourse().getId();
			this.courseName = r.getCourse().getName();
		}
		this.classRoom = r.getClassRoom();
	}
	
	public TeacherCourse createPo() {
		TeacherCourse po = new TeacherCourse();
		po.setId(id);
		Teacher teacher = new Teacher();
		if (!WoUtil.isEmpty(teacherId)&&!WoUtil.isEmpty(teacherName)) {
			teacher.setJobNo(teacherId);
			teacher.setName(teacherName);
			po.setTeacher(teacher);
		}
		Course course = new Course();
		if (!WoUtil.isEmpty(courseId)&&!WoUtil.isEmpty(courseName)) {
			course.setId(courseId);
			course.setName(courseName);
			po.setCourse(course);
		}
		po.setClassRoom(classRoom);
		return po;
	}
	
	public void upStringPO(TeacherCourse po) {
		po.setId(id);
		po.setClassRoom(classRoom);
		Teacher teacher = new Teacher();
		if (!WoUtil.isEmpty(teacherId)&&!WoUtil.isEmpty(teacherName)) {
			teacher.setJobNo(teacherId);
			teacher.setName(teacherName);
			po.setTeacher(teacher);
		}else {
			po.setTeacher(null);
		}
		
		if (!WoUtil.isEmpty(courseId)&&!WoUtil.isEmpty(courseName)) {
			Course course = new Course();
			course.setId(courseId);
			course.setName(courseName);
			po.setCourse(course);
		}else {
			po.setCourse(null);
		}
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

}
