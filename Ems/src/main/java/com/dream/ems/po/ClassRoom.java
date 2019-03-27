package com.dream.ems.po;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**教室
 * @author SXW
 * @date 2019年3月9日
 */
@Entity
@Table(name="t_classroom")
public class ClassRoom {
	private static Logger LOG = LogManager.getLogger(ClassRoom.class);
	
	@Id
	private String id;
	
	private String roomName;//比如A101

	public ClassRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassRoom(String id, String roomName) {
		super();
		this.id = id;
		this.roomName = roomName;
	}

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
	
}
