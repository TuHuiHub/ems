package com.dream.ems.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**班级
 * @author SXW
 * @date 2019年3月10日
 */
@Entity
@Table(name="t_clazz")
public class Clazz {
	private static Logger LOG = LogManager.getLogger(Clazz.class);
	
	@Id
	private String id;
	
	private String clazzName;
	
	@ManyToOne
	@JoinColumn(name="major_id")
	private Major major;//专业

	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clazz(String id, String clazzName, Major major) {
		super();
		this.id = id;
		this.clazzName = clazzName;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
}
