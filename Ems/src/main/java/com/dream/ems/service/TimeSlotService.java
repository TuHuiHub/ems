package com.dream.ems.service;

import com.dream.ems.dto.TimeSlotDto;
import com.dream.ems.po.TimeSlot;
import wo.common.entity.WoPage;

import java.util.List;

/**
 * PO实体TimeSlot对应的Service接口.
 * @author cailei
 */
public interface TimeSlotService {

	/**
	 * DataTable获取时间段列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	public WoPage<TimeSlotDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建时间段
	 * @param dto
	 */
	void create(TimeSlotDto dto);

	/**
	 * 根据id获取时间段数据
	 * @param id
	 * @return
	 */
	TimeSlotDto getById(String id);

	/**
	 * 修改时间段
	 * @param dto
	 */
	void update(TimeSlotDto dto);

	/**
	 * 根据id数组删除一个或者多个时间段
	 * @param id
	 */
	void delete(String[] id);
}
