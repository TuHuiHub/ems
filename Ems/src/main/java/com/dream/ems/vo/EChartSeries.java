package com.dream.ems.vo;

import java.util.ArrayList;
import java.util.List;


public class EChartSeries {
	
	private String name;
	
	private String type = "bar";
	
	private List<Integer> Data = new ArrayList<Integer>();

	public EChartSeries(String name, String type, List<Integer> data) {
		super();
		this.name = name;
		this.type = type;
		Data = data;
	}
	
	public EChartSeries(String name, List<Integer> data) {
		super();
		this.name = name;
		Data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Integer> getData() {
		return Data;
	}

	public void setData(List<Integer> data) {
		Data = data;
	}
}
