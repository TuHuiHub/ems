package com.dream.ems.vo;

import com.dream.ems.po.*;

import wo.common.util.WoUtil;
public class CourseArray {
	
	private String collegeId;
	
	private String majorId;

	private String courseId;
	
	private String courseName;
	
	private String teacherJobNo;
	
	private String teacherName;
	
	private String classRoomId;

	private String classRoomName;

	private String startWeek;
	
	private String endWeek;
	
	private String weekDay;
	
	private String lesson;
	
	private String coursetableId;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherJobNo() {
		return teacherJobNo;
	}

	public void setTeacherJobNo(String teacherJobNo) {
		this.teacherJobNo = teacherJobNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public String getCoursetableId() {
		return coursetableId;
	}

	public void setCoursetableId(String coursetableId) {
		this.coursetableId = coursetableId;
	}

	@Override
	public String toString() {
		return "CourseArray{" +
				"collegeId='" + collegeId + '\'' +
				", majorId='" + majorId + '\'' +
				", courseId='" + courseId + '\'' +
				", courseName='" + courseName + '\'' +
				", teacherJobNo='" + teacherJobNo + '\'' +
				", teacherName='" + teacherName + '\'' +
				", classRoomId='" + classRoomId + '\'' +
				", classRoomName='" + classRoomName + '\'' +
				", startWeek='" + startWeek + '\'' +
				", endWeek='" + endWeek + '\'' +
				", weekDay='" + weekDay + '\'' +
				", lesson='" + lesson + '\'' +
				", coursetableId='" + coursetableId + '\'' +
				'}';
	}

	public CourseTable createPo(){
		CourseTable ct = new CourseTable();
		if(!WoUtil.isEmpty(this.coursetableId)){
			ct.setId(Integer.parseInt(this.coursetableId));
		}
		if(!WoUtil.isEmpty(this.collegeId)){
			College college = new College();
			college.setId(this.collegeId);
			ct.setCollege(college);
		}
		if(!WoUtil.isEmpty(this.majorId)){
			Major major = new Major();
			major.setId(this.majorId);
			ct.setMajor(major);
		}
		if(!WoUtil.isEmpty(this.courseId)){
			Course course = new Course();
			course.setId(this.courseId);
			ct.setCourse(course);
		}
		if(!WoUtil.isEmpty(this.teacherJobNo)){
			Teacher teacher = new Teacher();
			teacher.setJobNo(this.teacherJobNo);
			ct.setTeacher(teacher);
		}
		if(!WoUtil.isEmpty(this.classRoomId)){
			ClassRoom classRoom = new ClassRoom();
			classRoom.setId(this.classRoomId);
			ct.setClassRoom(classRoom);
		}
		ct.setStartWeek(this.startWeek);
		ct.setEndWeek(this.endWeek);
		ct.setWeekDay(this.weekDay);
		ct.setLesson(this.lesson);
		return ct;
	}
}
