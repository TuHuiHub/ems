package com.dream.ems.dto;



import com.dream.ems.po.Course;
import com.dream.ems.po.Student;
import com.dream.ems.po.StudentCourse;
import com.dream.ems.po.Teacher;

import wo.common.util.WoUtil;

public class StudentCourseDto {

	

	
	private	String id;
	
	private String studentId;
	
	private String studentName;
	
	private String courseId;
	
	private String courseName;
	
	private String	teacherId;
	
	private String	teacherName;
	
	private String classRoom;
	

	private double score;
	
	public StudentCourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StudentCourseDto(StudentCourse r) {
		this.id = r.getId();
		if (r.getStudent()!=null) {
			this.studentId = r.getStudent().getStuNo();
			this.studentName = r.getStudent().getName();
		}
		if (r.getCourse()!=null) {
			this.courseId = r.getCourse().getId();
			this.courseName = r.getCourse().getName();
		}
		if (r.getTeacher()!=null) {
			this.teacherId = r.getTeacher().getJobNo();
			this.teacherName = r.getTeacher().getName();
		}
		this.classRoom = r.getClassRoom();
		this.score = r.getScore();
	}
	
	public StudentCourse createPo() {
		StudentCourse po = new StudentCourse();
		po.setId(id);
		Student student = new Student();
		if (!WoUtil.isEmpty(studentId)&&!WoUtil.isEmpty(studentName)) {
			student.setStuNo(studentId);
			student.setName(studentName);
			po.setStudent(student);
		}
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
		po.setScore(score);
		return po;
	}
	
	public void upStringPo(StudentCourse po) {
		po.setId(id);
	
		if (!WoUtil.isEmpty(studentId)&&!WoUtil.isEmpty(studentName)) {
			Student student = new Student();
			student.setStuNo(studentId);
			student.setName(studentName);
			po.setStudent(student);
		}else {
			po.setStudent(null);
		}
		
		if (!WoUtil.isEmpty(teacherId)&&!WoUtil.isEmpty(teacherName)) {
			Teacher teacher = new Teacher();
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
		po.setClassRoom(classRoom);
		po.setScore(score);
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getStudentId() {
		return studentId;
	}




	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}




	public String getStudentName() {
		return studentName;
	}




	public void setStudentName(String studentName) {
		this.studentName = studentName;
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




	@Override
	public String toString() {
		return "StudentCourseDto [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", courseId=" + courseId + ", courseName=" + courseName + ", teacherId=" + teacherId
				+ ", teacherName=" + teacherName + ", classRoom=" + classRoom + ", score=" + score + "]";
	}


}
