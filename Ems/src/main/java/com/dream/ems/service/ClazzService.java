package com.dream.ems.service;

import com.dream.ems.dto.ClazzDto;
import com.dream.ems.po.Clazz;
import com.dream.ems.po.Course;
import wo.common.entity.WoPage;

import java.util.List;

/**
 * PO实体Clazz对应的Service接口.
 * @author cailei
 */
public interface ClazzService {

	/**
	 * DataTable获取班级列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	public WoPage<ClazzDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建班级
	 * @param dto
	 */
	void create(ClazzDto dto);

	/**
	 * 根据id获取班级数据
	 * @param id
	 * @return
	 */
	ClazzDto getById(String id);

	/**
	 * 修改班级
	 * @param dto
	 */
	void update(ClazzDto dto);

	/**
	 * 根据id数组删除一个或者多个班级
	 * @param id
	 */
	void delete(String[] id);

    List<Clazz> getClazzByMajorId(String majorId);

    List<Clazz> getFreeClazz(String majorId, String courseId);
}
