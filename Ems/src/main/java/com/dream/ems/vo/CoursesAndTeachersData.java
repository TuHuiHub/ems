package com.dream.ems.vo;
import java.util.List;


import com.dream.ems.po.Course;
import com.dream.ems.po.Teacher;
public class CoursesAndTeachersData {
	
	public List<Teacher> teachers;
	public List<Course> courses;
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
