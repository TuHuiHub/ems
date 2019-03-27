package com.dream.ems.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学院
 * @author Ylinx
 * @date 2018年12月3日
 */
@Entity
@Table(name="t_college")
public class College {

	
	@Id
	@Column(length=20)
	private String id;
	
	@Column(length=100)
	private String name;

	public College() {
		super();
	}
	
	public College(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}
	
}
