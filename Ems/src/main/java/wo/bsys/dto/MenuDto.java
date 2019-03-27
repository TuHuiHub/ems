package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.entity.WoPage;
import wo.bsys.po.Menu;

/**
 * PO实体Menu对应的DTO类.
 * @author 
 */
public class MenuDto extends MenuDto_ {

	/**
	 * 无参构造函数
	 */
	public MenuDto() {
		super ();
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public MenuDto(Menu po) {
		super (po);
	}
	
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<MenuDto> getDtos (List<Menu> pos) {
		List<MenuDto> rs = new ArrayList<MenuDto>();
		for (Menu r : pos) {
			MenuDto dto = new MenuDto(r);
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
	public static WoPage<MenuDto> getPageData(List<Menu> pos, Long total) {
		WoPage<MenuDto> puDto = new WoPage<MenuDto>(getDtos(pos), total);
		return puDto;
	}
	
}
