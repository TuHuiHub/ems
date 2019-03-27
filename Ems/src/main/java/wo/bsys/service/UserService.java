package wo.bsys.service;

import wo.bsys.dto.UserDto;
import wo.bsys.vo.WoUser;
import wo.common.entity.WoPage;

/**
 * PO实体User对应的Service接口.
 * @author 
 */
public interface UserService {

	/**
	 * DataTable获取用户列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	WoPage<UserDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建用户
	 * @param dto
	 */
	void create(UserDto dto);

	/**
	 * 根据id获取用户数据
	 * @param id
	 * @return
	 */
	UserDto getById(String id);

	/**
	 * 修改用户
	 * @param dto
	 */
	void update(UserDto dto);

	/**
	 * 根据id数组删除一个或者多个用户
	 * @param id
	 */
	void delete(String[] id);

	void updatePassword(UserDto dto);


	void update(WoUser user);

}
