package com.dream.ems.po;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bsys_log")
public class OperationLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String clazz;
	@Column(length=100)
	private String method;
	@Column(length=4000)
	private String args;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column
	private long createTimeLong;
	public OperationLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationLog(Integer id, String clazz, String method, String args, Date createTime, long createTimeLong) {
		super();
		this.id = id;
		this.clazz = clazz;
		this.method = method;
		this.args = args;
		this.createTime = createTime;
		this.createTimeLong = createTimeLong;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getCreateTimeLong() {
		return createTimeLong;
	}
	public void setCreateTimeLong(long createTimeLong) {
		this.createTimeLong = createTimeLong;
	}
	
}
