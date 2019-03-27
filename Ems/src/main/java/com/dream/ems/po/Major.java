package com.dream.ems.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_major")
public class Major {

	
	@Id
	@Column(length=20)
	private String id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=20)
	private String eduSys;		//学制
	
	@ManyToOne
	@JoinColumn(name="college_id")
	private College college;

	public Major() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Major(String id, String name, String eduSys, College college) {
		super();
		this.id = id;
		this.name = name;
		this.eduSys = eduSys;
		this.college = college;
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

	public String getEduSys() {
		return eduSys;
	}

	public void setEduSys(String eduSys) {
		this.eduSys = eduSys;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", eduSys=" + eduSys + ", college=" + college + "]";
	}
	
	
}
