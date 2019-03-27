package wo.bsys.service;

import wo.bsys.dto.MenuDto;
import wo.common.entity.WoPage;

/**
 * PO实体Menu对应的Service接口.
 * @author 
 */
public interface MenuService {

	/**
	 * DataTable获取菜单列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	WoPage<MenuDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建菜单
	 * @param dto
	 */
	void create(MenuDto dto);

	/**
	 * 根据id获取菜单数据
	 * @param id
	 * @return
	 */
	MenuDto getById(String id);

	/**
	 * 修改菜单
	 * @param dto
	 */
	void update(MenuDto dto);

	/**
	 * 根据id数组删除一个或者多个菜单
	 * @param id
	 */
	void delete(String[] id);

}
