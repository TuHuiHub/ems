package com.dream.ems.dto;
import java.util.ArrayList;
import java.util.List;


import com.dream.ems.po.*;

import wo.bsys.po.Dictionary;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;
public class CourseTableDto {
	
	private Integer id;
	
	private String collegeId;
	private String collegeName;
	
	private String majorId;
	private String majorName;
	
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

	private String clazzId;
	private String clazzName;

	private String semesterId;
	private String semesterName;

	private List<StudentDto> studentDtos;

	public CourseTableDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
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

	public String getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public List<StudentDto> getStudentDtos() {
		return studentDtos;
	}
	public void setStudentDtos(List<StudentDto> studentDtos) {
		this.studentDtos = studentDtos;
	}

	public CourseTableDto (CourseTable po){
		this.id = po.getId();
		this.startWeek = po.getStartWeek();
		this.endWeek = po.getEndWeek();
		this.lesson = po.getLesson();
		this.weekDay = po.getWeekDay();
		
		if(!WoUtil.isEmpty(po.getCollege())){
			this.collegeId = po.getCollege().getId();
			this.collegeName = po.getCollege().getName();
		}
		if(!WoUtil.isEmpty(po.getMajor())){
			this.majorId = po.getMajor().getId();
			this.majorName = po.getMajor().getName();
		}
		if(!WoUtil.isEmpty(po.getTeacher())){
			this.teacherJobNo = po.getTeacher().getJobNo();
			this.teacherName = po.getTeacher().getName();
		}
		if(!WoUtil.isEmpty(po.getCourse())){
			this.courseId = po.getCourse().getId();
			this.courseName = po.getCourse().getName();
		}
		if(!WoUtil.isEmpty(po.getClassRoom())){
			this.classRoomId = po.getClassRoom().getId();
			this.classRoomName = po.getClassRoom().getRoomName();
		}
		if(!WoUtil.isEmpty(po.getClazz())){
			this.clazzId = po.getClazz().getId();
			this.clazzName = po.getClazz().getClazzName();
		}
		if(!WoUtil.isEmpty(po.getSemester())){
			this.semesterId = po.getSemester().getId();
			this.semesterName = po.getSemester().getName();
		}
		if(!WoUtil.isEmpty(po.getStudents())){
			this.studentDtos = StudentDto.getDtos(po.getStudents());
		}
	}
	
	public CourseTable createPo(){
		CourseTable po = new CourseTable();
		po.setStartWeek(this.startWeek);
		po.setEndWeek(this.endWeek);
		po.setLesson(this.lesson);
		po.setWeekDay(this.weekDay);
		if(!WoUtil.isEmpty(this.collegeId)){
			College college = new College();
			college.setId(this.collegeId);
			po.setCollege(college);
		}
		
		if(!WoUtil.isEmpty(this.majorId)){
			Major major = new Major();
			major.setId(this.majorId);
			po.setMajor(major);
		}
		
		if(!WoUtil.isEmpty(this.courseId)){
			Course course = new Course();
			course.setId(this.courseId);
			po.setCourse(course);
		}
		
		if(!WoUtil.isEmpty(this.teacherJobNo)){
			Teacher teacher = new Teacher();
			teacher.setJobNo(this.teacherJobNo);
			po.setTeacher(teacher);
		}
		if(!WoUtil.isEmpty(this.classRoomId)){
			ClassRoom classRoom = new ClassRoom();
			classRoom.setId(this.classRoomId);
			po.setClassRoom(classRoom);
		}
		if(!WoUtil.isEmpty(this.clazzId)){
			Clazz clazz = new Clazz();
			clazz.setId(this.clazzId);
			po.setClazz(clazz);
		}
		if(!WoUtil.isEmpty(this.semesterId)){
			Dictionary semester = new Dictionary();
			semester.setId(this.semesterId);
			po.setSemester(semester);
		}
		return po;
	}
	
	public CourseTable updatePo(){
		CourseTable po = new CourseTable();
		po.setId(this.id);
		po.setStartWeek(this.startWeek);
		po.setEndWeek(this.endWeek);
		po.setLesson(this.lesson);
		po.setWeekDay(this.weekDay);
		if(!WoUtil.isEmpty(this.collegeId)){
			College college = new College();
			college.setId(this.collegeId);
			po.setCollege(college);
		}
		
		if(!WoUtil.isEmpty(this.majorId)){
			Major major = new Major();
			major.setId(this.majorId);
			po.setMajor(major);
		}
		
		if(!WoUtil.isEmpty(this.courseId)){
			Course course = new Course();
			course.setId(this.courseId);
			po.setCourse(course);
		}
		
		if(!WoUtil.isEmpty(this.teacherJobNo)){
			Teacher teacher = new Teacher();
			teacher.setJobNo(this.teacherJobNo);
			po.setTeacher(teacher);
		}
		if(!WoUtil.isEmpty(this.classRoomId)){
			ClassRoom classRoom = new ClassRoom();
			classRoom.setId(this.classRoomId);
			po.setClassRoom(classRoom);
		}
		if(!WoUtil.isEmpty(this.clazzId)){
			Clazz clazz = new Clazz();
			clazz.setId(this.clazzId);
			po.setClazz(clazz);
		}
		if(!WoUtil.isEmpty(this.semesterId)){
			Dictionary semester = new Dictionary();
			semester.setId(this.semesterId);
			po.setSemester(semester);
		}
		return po;
	}
	public static List<CourseTableDto> getDtos(List<CourseTable> pos){
		
		 List<CourseTableDto> dtos = new ArrayList<>();
		 for (CourseTable po : pos) {
			CourseTableDto dto = new CourseTableDto(po);
			dtos.add(dto);
		}
		 return dtos;
	}

	public static WoPage<CourseTableDto> getPageData(List<CourseTable> content, long totalElements) {
		List<CourseTableDto> dtos = new ArrayList<CourseTableDto>();
		for (CourseTable po : content) {
			dtos.add(new CourseTableDto(po));
		}
		return new WoPage<CourseTableDto>(dtos, totalElements);
	}

	@Override
	public String toString() {
		return "CourseTableDto{" +
				"id=" + id +
				", collegeId='" + collegeId + '\'' +
				", collegeName='" + collegeName + '\'' +
				", majorId='" + majorId + '\'' +
				", majorName='" + majorName + '\'' +
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
				", clazzId='" + clazzId + '\'' +
				", clazzName='" + clazzName + '\'' +
				'}';
	}
}
