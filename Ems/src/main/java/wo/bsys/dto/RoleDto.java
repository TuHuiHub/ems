package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.entity.WoPage;
import wo.bsys.po.Role;

/**
 * PO实体Role对应的DTO类.
 * @author 
 */
public class RoleDto extends RoleDto_ {

	/**
	 * 无参构造函数
	 */
	public RoleDto() {
		super ();
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public RoleDto(Role po) {
		super (po);
	}
	
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<RoleDto> getDtos (List<Role> pos) {
		List<RoleDto> rs = new ArrayList<RoleDto>();
		for (Role r : pos) {
			RoleDto dto = new RoleDto(r);
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
	public static WoPage<RoleDto> getPageData(List<Role> pos, Long total) {
		WoPage<RoleDto> puDto = new WoPage<RoleDto>(getDtos(pos), total);
		return puDto;
	}
	
}
