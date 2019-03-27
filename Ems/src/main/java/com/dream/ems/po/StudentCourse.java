package com.dream.ems.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_student_course")
public class StudentCourse {

	
	@Id
	@Column
	private	String id;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher	teacher;
	
	@Column(length=50)
	private String classRoom;

	@Column(length=20)
	private double score;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}


	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(String id, Student student, Course course, Teacher teacher, String classRoom,
			 double score) {
		super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.teacher = teacher;
		this.classRoom = classRoom;
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", student=" + student + ", course=" + course + ", teacher=" + teacher
				+ ", classRoom=" + classRoom + ", score=" + score + "]";
	}


	
}
