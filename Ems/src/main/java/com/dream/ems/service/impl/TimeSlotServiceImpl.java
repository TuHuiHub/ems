package com.dream.ems.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dream.ems.dto.TimeSlotDto;
import com.dream.ems.po.TimeSlot;
import com.dream.ems.repository.TimeSlotRepository;
import com.dream.ems.service.TimeSlotService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

import java.util.List;

/**
 * PO实体TimeSlot对应的Service接口实现类.
 * @author cailei
 */
@Service
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService {

	/**
	 * 使用日志打印框架.
	 */
	private final static Logger LOG = LogManager.getLogger(TimeSlotServiceImpl.class);

	/**
	 * 注入TimeSlotRepository.
	 */
	@Resource // @Autowired
	private TimeSlotRepository timeSlotRepository;

	/**
	 * DataTable获取时间段列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<TimeSlotDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<TimeSlot> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = timeSlotRepository.findAll(pageInput);
		} else {
			pageData = timeSlotRepository.findAllByTimeLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<TimeSlotDto> pr = TimeSlotDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建时间段
	 * @param dto
	 */
	@Override
	public void create(TimeSlotDto dto) {
		TimeSlot po = dto.createPO();
		timeSlotRepository.save(po);
	}

	/**
	 * 根据id获取时间段数据
	 * @param id
	 * @return
	 */
	@Override
	public TimeSlotDto getById(String id) {
		TimeSlot po = timeSlotRepository.findById(id).get();
		return new TimeSlotDto (po);
	}

	/**
	 * 修改时间段
	 * @param dto
	 */
	@Override
	public void update(TimeSlotDto dto) {
		TimeSlot po = timeSlotRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个时间段
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		timeSlotRepository.deleteByIdIn(id);
	}

}
