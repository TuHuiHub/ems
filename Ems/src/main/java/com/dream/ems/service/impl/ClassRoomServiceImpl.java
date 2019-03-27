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

import com.dream.ems.dto.ClassRoomDto;
import com.dream.ems.po.ClassRoom;
import com.dream.ems.repository.ClassRoomRepository;
import com.dream.ems.service.ClassRoomService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

import java.util.List;

/**
 * PO实体ClassRoom对应的Service接口实现类.
 * @author cailei
 */
@Service
@Transactional
public class ClassRoomServiceImpl implements ClassRoomService {

	/**
	 * 使用日志打印框架.
	 */
	private final static Logger LOG = LogManager.getLogger(ClassRoomServiceImpl.class);

	/**
	 * 注入ClassRoomRepository.
	 */
	@Resource // @Autowired
	private ClassRoomRepository classRoomRepository;

	/**
	 * DataTable获取教室列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<ClassRoomDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<ClassRoom> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = classRoomRepository.findAll(pageInput);
		} else {
			pageData = classRoomRepository.findAllByroomNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<ClassRoomDto> pr = ClassRoomDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建教室
	 * @param dto
	 */
	@Override
	public void create(ClassRoomDto dto) {
		ClassRoom po = dto.createPO();
		classRoomRepository.save(po);
	}

	/**
	 * 根据id获取教室数据
	 * @param id
	 * @return
	 */
	@Override
	public ClassRoomDto getById(String id) {
		ClassRoom po = classRoomRepository.findById(id).get();
		return new ClassRoomDto (po);
	}

	/**
	 * 修改教室
	 * @param dto
	 */
	@Override
	public void update(ClassRoomDto dto) {
		ClassRoom po = classRoomRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个教室
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		classRoomRepository.deleteByIdIn(id);
	}

	@Override
	public List<ClassRoom> getAllRoomsByTime(String week, String lesson) {
		// 获取指定时间段排了课的教室
		List<Integer> ints = classRoomRepository.findAllByWeekDayAndLesson(week, lesson);
		// 获取空闲教室
		return classRoomRepository.findAllByIdNotIn(ints);
	}
}
