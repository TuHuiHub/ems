package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.util.WoUtil;
import wo.common.entity.WoPage;
import com.dream.ems.po.ClassRoom;

/**
 * PO实体ClassRoom对应的DTO类.
 * @author cailei
 */
public class ClassRoomDto {

	private String id;

	private String roomName;//比如A101

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", roomName=" + roomName + "]";
	}

	/**
	 * 无参构造函数
	 */
	public ClassRoomDto() {
		super ();
	}

	public ClassRoomDto(String id, String roomName) {
		super();
		this.id = id;
		this.roomName = roomName;
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public ClassRoomDto(ClassRoom po) {
		this.id = po.getId();
		this.roomName = po.getRoomName();
	}

	/**创造PO
	 * @return
	 */
	public ClassRoom createPO() {
		ClassRoom po = new ClassRoom();
		// 设置PO主键id
		if (WoUtil.isEmpty(this.id)) {
			po.setId(java.util.UUID.randomUUID().toString());
		} else {
			po.setId(this.id);
		}
		// 设置PO属性roomName
		po.setRoomName(this.roomName);

		return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(ClassRoom po) {
		po.setId(this.id);
		// 设置PO属性roomName
		po.setRoomName(this.roomName);

	}

	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<ClassRoomDto> getDtos (List<ClassRoom> pos) {
		List<ClassRoomDto> rs = new ArrayList<ClassRoomDto>();
		for (ClassRoom r : pos) {
			ClassRoomDto dto = new ClassRoomDto(r);
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
	public static WoPage<ClassRoomDto> getPageData(List<ClassRoom> pos, Long total) {
		WoPage<ClassRoomDto> puDto = new WoPage<ClassRoomDto>(getDtos(pos), total);
		return puDto;
	}

}
