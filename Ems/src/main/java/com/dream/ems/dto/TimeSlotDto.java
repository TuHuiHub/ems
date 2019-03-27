package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.util.WoUtil;
import wo.common.entity.WoPage;

import com.dream.ems.po.ClassRoom;
import com.dream.ems.po.Teacher;
import com.dream.ems.po.TimeSlot;

/**
 * PO实体TimeSlot对应的DTO类.
 * @author sxw
 */
public class TimeSlotDto {

	private String id;

	private String week;

	private String time;
	
	/**
	 * 对应PO的teachers属性,多对多关联实体Teacher的主键值,如有多个以逗号隔开
	 */
	private String teachersJobNo = "";

	/**
	 * 对应PO的teachers属性,多对多关联实体Teacher的name属性值,如有多个以逗号隔开
	 */
	private String teachersName = "";
	/**
	 * 对应PO的classRooms属性,多对多关联实体ClassRoom的主键值,如有多个以逗号隔开
	 */
	private String classRoomsId = "";

	/**
	 * 对应PO的classRooms属性,多对多关联实体ClassRoom的roomName属性值,如有多个以逗号隔开
	 */
	private String classRoomsRoomName = "";
	
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

	public String getTeachersJobNo() {
		return teachersJobNo;
	}

	public void setTeachersJobNo(String teachersJobNo) {
		this.teachersJobNo = teachersJobNo;
	}

	public String getTeachersName() {
		return teachersName;
	}

	public void setTeachersName(String teachersName) {
		this.teachersName = teachersName;
	}

	public String getClassRoomsId() {
		return classRoomsId;
	}

	public void setClassRoomsId(String classRoomsId) {
		this.classRoomsId = classRoomsId;
	}

	public String getClassRoomsRoomName() {
		return classRoomsRoomName;
	}

	public void setClassRoomsRoomName(String classRoomsRoomName) {
		this.classRoomsRoomName = classRoomsRoomName;
	}

	/**
	 * 无参构造函数
	 */
	public TimeSlotDto() {
		super ();
	}

	public TimeSlotDto(String id, String week, String time, String teachersJobNo, String teachersName, String classRoomsId,
			String classRoomsRoomName) {
		super();
		this.id = id;
		this.week = week;
		this.time = time;
		this.teachersJobNo = teachersJobNo;
		this.teachersName = teachersName;
		this.classRoomsId = classRoomsId;
		this.classRoomsRoomName = classRoomsRoomName;
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public TimeSlotDto(TimeSlot po) {
		// 设置主键id
				this.id = po.getId();
				this.week = po.getWeek();
				this.time = po.getTime();
				// 设置DTO的teachers属性值
				for (Teacher p : po.getTeachers()) {
					if (!"".equals(teachersJobNo)) {
						teachersJobNo += ",";
						teachersName += ",";
					}
					teachersJobNo += p.getJobNo();
					teachersName += p.getName();
				}
				// 设置DTO的classRooms属性值
				for (ClassRoom p : po.getClassRooms()) {
					if (!"".equals(classRoomsId)) {
						classRoomsId += ",";
						classRoomsRoomName += ",";
					}
					classRoomsId += p.getId();
					classRoomsRoomName += p.getRoomName();
				}
	}
	
	/**
	 * 将当前对象转化为po
	 * @return
	 */
	public TimeSlot createPO() {
		TimeSlot po = new TimeSlot();
		// 设置PO主键id
		if (WoUtil.isEmpty(this.id)) {
			po.setId(java.util.UUID.randomUUID().toString());
		} else {
			po.setId(this.id);
		}
		po.setWeek(this.week);
		po.setTime(this.time);

		// 设置PO的teachers属性值
		List<Teacher> teachers = new ArrayList<Teacher>();
		String[] teachersJobNoArray = WoUtil.splitIds(teachersJobNo);
		for (String id : teachersJobNoArray) {
			Teacher p = new Teacher();
			p.setJobNo(id);
			teachers.add(p);
		}
		po.setTeachers(teachers);
		// 设置PO的classRooms属性值
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		String[] classRoomsIdArray = WoUtil.splitIds(classRoomsId);
		for (String id : classRoomsIdArray) {
			ClassRoom p = new ClassRoom();
			p.setId(id);
			classRooms.add(p);
		}
		po.setClassRooms(classRooms);
		return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(TimeSlot po) {
		po.setWeek(this.week);
		po.setTime(this.time);

		// 设置PO的teachers属性值:M2M
		List<Teacher> teachers = new ArrayList<Teacher>();
		String[] teachersJobNoArray = WoUtil.splitIds(teachersJobNo);
		for (String id : teachersJobNoArray) {
			Teacher p = new Teacher();
			p.setJobNo(id);
			teachers.add(p);
		}
		po.setTeachers(teachers);
		// 设置PO的classRooms属性值:M2M
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		String[] classRoomsIdArray = WoUtil.splitIds(classRoomsId);
		for (String id : classRoomsIdArray) {
			ClassRoom p = new ClassRoom();
			p.setId(id);
			classRooms.add(p);
		}
		po.setClassRooms(classRooms);
	}
	
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<TimeSlotDto> getDtos (List<TimeSlot> pos) {
		List<TimeSlotDto> rs = new ArrayList<TimeSlotDto>();
		for (TimeSlot r : pos) {
			TimeSlotDto dto = new TimeSlotDto(r);
			rs.add(dto);
		}
		return rs;
	}
	
	/**
	 * 将分页PO数据转化为DTO分页数据
	 * @param pos 当前页的PO数据集合
	 * @param total 数据总行数
	 * @return
	 */
	public static WoPage<TimeSlotDto> getPageData(List<TimeSlot> pos, Long total) {
		WoPage<TimeSlotDto> puDto = new WoPage<TimeSlotDto>(getDtos(pos), total);
		return puDto;
	}
	
}
