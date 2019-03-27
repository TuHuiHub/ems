package com.dream.ems.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_teacher_course")
public class TeacherCourse {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private String id;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher	teacher;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@Column(length=50)
	private String classRoom;
	@Column(length=50)
	private String courseName;
	public TeacherCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherCourse(String id, Teacher teacher, Course course, String classRoom, String courseName) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.course = course;
		this.classRoom = classRoom;
		this.courseName = courseName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
}
