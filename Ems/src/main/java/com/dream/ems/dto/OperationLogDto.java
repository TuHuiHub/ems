package com.dream.ems.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.dream.ems.po.OperationLog;
import com.fasterxml.jackson.annotation.JsonFormat;

import wo.common.entity.WoPage;
import wo.common.util.WoConstant;
public class OperationLogDto {
	
	private Integer id;
	
	private String clazz;
	
	private String method;
	
	private String args;
	
	private Date createTime;
	
	private Long createTimeLong;

	public OperationLogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationLogDto(Integer id, String clazz, String method, String args, Date createTime, Long createTimeLong) {
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

	@JsonFormat(pattern = WoConstant.FORMAT_DATETIME, locale = "zh", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateTimeLong() {
		return createTimeLong;
	}

	public void setCreateTimeLong(Long createTimeLong) {
		this.createTimeLong = createTimeLong;
	}
	
	public OperationLogDto(OperationLog po){
		this.id = po.getId();
		this.clazz = po.getClazz();
		this.method = po.getMethod();
		this.args = po.getArgs();
		this.createTime = po.getCreateTime();
		this.createTimeLong = po.getCreateTimeLong();
	}

	public static WoPage<OperationLogDto> getPageData(List<OperationLog> content, long totalElements) {
		List<OperationLogDto> dtos = new ArrayList<OperationLogDto>();
		for (OperationLog po : content) {
			dtos.add(new OperationLogDto(po));
		}
		return new WoPage<OperationLogDto>(dtos, totalElements);
	}
}
