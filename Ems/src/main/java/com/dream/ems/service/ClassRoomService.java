package com.dream.ems.service;

import com.dream.ems.dto.ClassRoomDto;
import com.dream.ems.po.ClassRoom;
import wo.common.entity.WoPage;

import java.util.List;

/**
 * PO实体ClassRoom对应的Service接口.
 * @author cailei
 */
public interface ClassRoomService {

	/**
	 * DataTable获取教室列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	public WoPage<ClassRoomDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建教室
	 * @param dto
	 */
	void create(ClassRoomDto dto);

	/**
	 * 根据id获取教室数据
	 * @param id
	 * @return
	 */
	ClassRoomDto getById(String id);

	/**
	 * 修改教室
	 * @param dto
	 */
	void update(ClassRoomDto dto);

	/**
	 * 根据id数组删除一个或者多个教室
	 * @param id
	 */
	void delete(String[] id);

    List<ClassRoom> getAllRoomsByTime(String week, String time);
}
