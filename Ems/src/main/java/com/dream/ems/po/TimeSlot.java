package com.dream.ems.po;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import wo.bsys.po.Role;
/**时间段
 * @author SXW
 * @date 2019年3月9日
 */
@Entity
@Table(name="t_timeslot")
public class TimeSlot {
	private static Logger LOG = LogManager.getLogger(TimeSlot.class);
	
	@Id
	private String id;

	private String week;

	private String time;
	
	@ManyToMany
	@JoinTable(name="t_time_teacher",joinColumns= {@JoinColumn(name="timeslot_id")},
	inverseJoinColumns= {@JoinColumn(name="teacher_id")})
	private List<Teacher> teachers;
	
	@ManyToMany
	@JoinTable(name="t_time_classroom",joinColumns= {@JoinColumn(name="timeslot_id")},
	inverseJoinColumns= {@JoinColumn(name="classroom_id")})
	private List<ClassRoom> classRooms;

	public TimeSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSlot(String id, String week, String time, List<Teacher> teachers, List<ClassRoom> classRooms) {
		super();
		this.id = id;
		this.week = week;
		this.time = time;
		this.teachers = teachers;
		this.classRooms = classRooms;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}
	
}
