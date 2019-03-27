package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.entity.WoPage;
import wo.bsys.po.User;

/**
 * PO实体User对应的DTO类.
 * @author 
 */
public class UserDto extends UserDto_ {

	/**
	 * 无参构造函数
	 */
	public UserDto() {
		super ();
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public UserDto(User po) {
		super (po);
	}
	
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<UserDto> getDtos (List<User> pos) {
		List<UserDto> rs = new ArrayList<UserDto>();
		for (User r : pos) {
			UserDto dto = new UserDto(r);
			rs.add(dto);
		}
		return rs;
	}
	
	/**
	 * 将分页PO数据转化为DTO分页数据
	 * @param pos 当前页的PO数据集合
	 * @param total 数据总行数
	 * @return
	 */
	public static WoPage<UserDto> getPageData(List<User> pos, Long total) {
		WoPage<UserDto> puDto = new WoPage<UserDto>(getDtos(pos), total);
		return puDto;
	}
	
}
