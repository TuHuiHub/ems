package wo.bsys.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import wo.bsys.dto.MenuDto;
import wo.bsys.po.Menu;
import wo.bsys.repository.MenuRepository;
import wo.bsys.service.MenuService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

/**
 * PO实体Menu对应的Service接口实现类.
 * @author 
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	/**
	 * 使用日志打印框架.
	 */

	/**
	 * 注入MenuRepository.
	 */
	@Resource // @Autowired
	private MenuRepository menuRepository;

	/**
	 * DataTable获取菜单列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<MenuDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 , "desc".equals(dir) ? Direction.DESC : Direction.ASC, "no"  );
		Page<Menu> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = menuRepository.findAll(pageInput);
		} else {
			pageData = menuRepository.findAllBynameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<MenuDto> pr = MenuDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建菜单
	 * @param dto
	 */
	@Override
	public void create(MenuDto dto) {
		Menu po = dto.createPO();
		menuRepository.save(po);
	}

	/**
	 * 根据id获取菜单数据
	 * @param id
	 * @return
	 */
	@Override
	public MenuDto getById(String id) {
		Menu po = menuRepository.findById(id).get();
		return new MenuDto (po);
	}

	/**
	 * 修改菜单
	 * @param dto
	 */
	@Override
	public void update(MenuDto dto) {
		Menu po = menuRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个菜单
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		menuRepository.deleteByIdIn(id);
	}

}
