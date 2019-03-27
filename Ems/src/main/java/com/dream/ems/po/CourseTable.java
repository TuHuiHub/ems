package com.dream.ems.po;

import wo.bsys.po.Dictionary;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="coursetable")
public class CourseTable {
	@Override
	public String toString() {
		return "CourseTable [id=" + id + ", college=" + college + ", major=" + major + ", course=" + course
				+ ", teacher=" + teacher + ", classRoom=" + classRoom + ", startWeek=" + startWeek + ", endWeek="
				+ endWeek + ", weekDay=" + weekDay + ", lesson=" + lesson + ", students=" + students + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="collegeId")
	private College college;
	@ManyToOne
	@JoinColumn(name="majorId")
	private Major major;
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;
	@ManyToOne
	@JoinColumn(name="teacherJobNo")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name="classRoomId")
	private ClassRoom classRoom;
	@Column
	private String startWeek;
	@Column
	private String endWeek;
	@Column
	private String weekDay;
	@Column
	private String lesson;
	@ManyToOne
	@JoinColumn(name = "clazzId")
	private Clazz clazz;
	@ManyToOne
	@JoinColumn(name = "semesterId")
	private Dictionary semester;
	@ManyToMany
	@JoinTable(name = "t_coursetable_student",
		joinColumns = { @JoinColumn(name = "coursetableId") },
		inverseJoinColumns = {@JoinColumn(name = "studentStuNo") })
	private List<Student> students;
	public CourseTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseTable(Integer id, College college, Major major, Course course, Teacher teacher, ClassRoom classRoom,
			String startWeek, String endWeek, String weekDay, String lesson, List<Student> students) {
		super();
		this.id = id;
		this.college = college;
		this.major = major;
		this.course = course;
		this.teacher = teacher;
		this.classRoom = classRoom;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.weekDay = weekDay;
		this.lesson = lesson;
		this.students = students;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
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
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Dictionary getSemester() {
		return semester;
	}
	public void setSemester(Dictionary semester) {
		this.semester = semester;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
}
