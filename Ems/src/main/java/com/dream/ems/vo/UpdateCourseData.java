package com.dream.ems.vo;
import java.util.List;

public class UpdateCourseData {
	
	private List<CourseArray> courseArray;
	
	private List<String> delCourseTableIds;

	public List<CourseArray> getCourseArray() {
		return courseArray;
	}

	public void setCourseArray(List<CourseArray> courseArray) {
		this.courseArray = courseArray;
	}

	public List<String> getDelCourseTableIds() {
		return delCourseTableIds;
	}

	public void setDelCourseTableIds(List<String> delCourseTableIds) {
		this.delCourseTableIds = delCourseTableIds;
	}

	
	
}
