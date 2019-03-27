package wo.bsys.service;

import java.util.List;

import wo.bsys.dto.DictionaryDto;
import wo.common.entity.WoPage;

/**
 * PO实体Dictionary对应的Service接口.
 * @author 
 */
public interface DictionaryService {

	/**
	 * DataTable获取数据字典列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	WoPage<DictionaryDto> getPageData(Long start, Long length, String searchContent, String dir);

	/**
	 * 创建数据字典
	 * @param dto
	 */
	void create(DictionaryDto dto);

	/**
	 * 根据id获取数据字典数据
	 * @param id
	 * @return
	 */
	DictionaryDto getById(String id);

	/**
	 * 修改数据字典
	 * @param dto
	 */
	void update(DictionaryDto dto);

	/**
	 * 根据id数组删除一个或者多个数据字典
	 * @param id
	 */
	void delete(String[] id);

	/**
	 * @param string
	 * @return
	 */
	List<DictionaryDto> getAllByDicType(String string);

}
