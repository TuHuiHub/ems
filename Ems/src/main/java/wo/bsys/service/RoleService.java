package wo.bsys.service;

import wo.bsys.dto.RoleDto;
import wo.common.entity.WoPage;

/**
 * PO实体Role对应的Service接口.
 * @author 
 */
public interface RoleService {

	/**
	 * DataTable获取角色列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	WoPage<RoleDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建角色
	 * @param dto
	 */
	void create(RoleDto dto);

	/**
	 * 根据id获取角色数据
	 * @param id
	 * @return
	 */
	RoleDto getById(String id);

	/**
	 * 修改角色
	 * @param dto
	 */
	void update(RoleDto dto);

	/**
	 * 根据id数组删除一个或者多个角色
	 * @param id
	 */
	void delete(String[] id);

}
