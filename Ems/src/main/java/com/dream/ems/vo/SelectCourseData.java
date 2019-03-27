package com.dream.ems.vo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SelectCourseData {
	private Logger LOG = LogManager.getLogger(SelectCourseData.class);
	
	private String collegeId;
	
	private String majorId;

	private String courseId;
	
	private String courseName;
	
	private String teacherJobNo;
	
	private String teacherName;
	
	private String classRoomId;

	private String classRoomName;

	private String classTime;
	
	private String startWeek;
	
	private String endWeek;
	
	private String weekDay;
	
	private String lesson;

	private String clazzId;

	private String clazzName;

	public SelectCourseData() {
		
	}

	public Logger getLOG() {
		return LOG;
	}

	public void setLOG(Logger lOG) {
		LOG = lOG;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}



	public String getTeacherJobNo() {
		return teacherJobNo;
	}

	public void setTeacherJobNo(String teacherJobNo) {
		this.teacherJobNo = teacherJobNo;
	}

	public String getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(String classRoomId) {
		this.classRoomId = classRoomId;
	}

	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(String startWeek) {
		this.startWeek = startWeek;
	}

	public String getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(String endWeek) {
		this.endWeek = endWeek;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

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

	@Override
	public String toString() {
		return "SelectCourseData{" +
				"collegeId='" + collegeId + '\'' +
				", majorId='" + majorId + '\'' +
				", courseId='" + courseId + '\'' +
				", courseName='" + courseName + '\'' +
				", teacherJobNo='" + teacherJobNo + '\'' +
				", teacherName='" + teacherName + '\'' +
				", classRoomId='" + classRoomId + '\'' +
				", classRoomName='" + classRoomName + '\'' +
				", classTime='" + classTime + '\'' +
				", startWeek='" + startWeek + '\'' +
				", endWeek='" + endWeek + '\'' +
				", weekDay='" + weekDay + '\'' +
				", lesson='" + lesson + '\'' +
				'}';
	}
}
