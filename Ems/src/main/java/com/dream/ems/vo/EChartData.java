package com.dream.ems.vo;

import java.util.ArrayList;
import java.util.List;


public class EChartData {
	
	
	private List<String> legends = new ArrayList<String>();
	
	private List<String> xAxis = new ArrayList<String>();
	
	private List<String> yAxis = new ArrayList<String>();
	
	private List<EChartSeries> series = new ArrayList<EChartSeries>();

	public List<String> getLegends() {
		return legends;
	}

	public void setLegends(List<String> legends) {
		this.legends = legends;
	}

	public List<String> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}

	public List<EChartSeries> getSeries() {
		return series;
	}

	public void setSeries(List<EChartSeries> series) {
		this.series = series;
	}

	public List<String> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<String> yAxis) {
		this.yAxis = yAxis;
	}
	
}
