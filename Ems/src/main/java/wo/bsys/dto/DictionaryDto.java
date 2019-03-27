package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.entity.WoPage;
import wo.bsys.po.Dictionary;

/**
 * PO实体Dictionary对应的DTO类.
 * @author 
 */
public class DictionaryDto extends DictionaryDto_ {

	/**
	 * 无参构造函数
	 */
	public DictionaryDto() {
		super ();
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public DictionaryDto(Dictionary po) {
		super (po);
	}
	
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<DictionaryDto> getDtos (List<Dictionary> pos) {
		List<DictionaryDto> rs = new ArrayList<DictionaryDto>();
		for (Dictionary r : pos) {
			DictionaryDto dto = new DictionaryDto(r);
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
	public static WoPage<DictionaryDto> getPageData(List<Dictionary> pos, Long total) {
		WoPage<DictionaryDto> puDto = new WoPage<DictionaryDto>(getDtos(pos), total);
		return puDto;
	}
	
}
