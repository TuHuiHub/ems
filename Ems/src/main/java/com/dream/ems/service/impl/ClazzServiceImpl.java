package com.dream.ems.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.dream.ems.po.Course;
import com.dream.ems.repository.CourseRepository;
import com.dream.ems.service.CourseService;
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

import com.dream.ems.dto.ClazzDto;
import com.dream.ems.po.Clazz;
import com.dream.ems.repository.ClazzRepository;
import com.dream.ems.service.ClazzService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

import java.util.List;
import java.util.Optional;

/**
 * PO实体Clazz对应的Service接口实现类.
 * @author cailei
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

	/**
	 * 使用日志打印框架.
	 */
	private final static Logger LOG = LogManager.getLogger(ClazzServiceImpl.class);

	/**
	 * 注入ClazzRepository.
	 */
	@Resource // @Autowired
	private ClazzRepository clazzRepository;
	@Resource
	private CourseService courseService;
	@Resource
	private CourseRepository courseRepository;

	/**
	 * DataTable获取班级列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<ClazzDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<Clazz> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = clazzRepository.findAll(pageInput);
		} else {
			pageData = clazzRepository.findAllByclazzNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<ClazzDto> pr = ClazzDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建班级
	 * @param dto
	 */
	@Override
	public void create(ClazzDto dto) {
		Clazz po = dto.createPO();
		clazzRepository.save(po);
	}

	/**
	 * 根据id获取班级数据
	 * @param id
	 * @return
	 */
	@Override
	public ClazzDto getById(String id) {
		Clazz po = clazzRepository.findById(id).get();
		return new ClazzDto (po);
	}

	/**
	 * 修改班级
	 * @param dto
	 */
	@Override
	public void update(ClazzDto dto) {
		Clazz po = clazzRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个班级
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		clazzRepository.deleteByIdIn(id);
	}

	@Override
	public List<Clazz> getClazzByMajorId(String majorId) {
		return clazzRepository.findAllByMajorId(majorId);
	}

	@Override
	public List<Clazz> getFreeClazz(String majorId, String courseId) {
		Course course = courseRepository.findById(courseId).get();
		// 每周安排次数
		Long time = (long) (Integer.parseInt(course.getCourseWeek()) / (Integer.parseInt(course.getEndWeek()) - Integer.parseInt(course.getStartWeek()) + 1));
		// 获取排满课程ID
		List<Integer> ints = clazzRepository.findAllNotFreeClazz(course.getId(), time);
		if (ints.size() == 0) {
			return clazzRepository.findAllByMajorId(majorId);
		} else {
			// 获取未排满课程
			return clazzRepository.findAllFreeClazz(majorId, ints);
		}
	}

}
