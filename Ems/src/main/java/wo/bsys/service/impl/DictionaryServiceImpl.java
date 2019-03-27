package wo.bsys.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import wo.bsys.dto.DictionaryDto;
import wo.bsys.po.Dictionary;
import wo.bsys.repository.DictionaryRepository;
import wo.bsys.service.DictionaryService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

/**
 * PO实体Dictionary对应的Service接口实现类.
 * @author 
 */
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {


	/**
	 * 注入DictionaryRepository.
	 */
	@Resource // @Autowired
	private DictionaryRepository dictionaryRepository;

	/**
	 * DataTable获取数据字典列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<DictionaryDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<Dictionary> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = dictionaryRepository.findAll(pageInput);
		} else {
			pageData = dictionaryRepository.findAllBydicTypeLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<DictionaryDto> pr = DictionaryDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建数据字典
	 * @param dto
	 */
	@Override
	public void create(DictionaryDto dto) {
		Dictionary po = dto.createPO();
		dictionaryRepository.save(po);
	}

	/**
	 * 根据id获取数据字典数据
	 * @param id
	 * @return
	 */
	@Override
	public DictionaryDto getById(String id) {
		Dictionary po = dictionaryRepository.findById(id).get();
		return new DictionaryDto(po);
	}

	/**
	 * 修改数据字典
	 * @param dto
	 */
	@Override
	public void update(DictionaryDto dto) {
		Dictionary po = dictionaryRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个数据字典
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		dictionaryRepository.deleteByIdIn(id);
	}

	@Override
	public List<DictionaryDto> getAllByDicType(String string) {
		// 根据数据字典类型，查询po集合
		List<Dictionary> pos = this.dictionaryRepository.findAllBydicType(string);
		// 将po集合转化为dto集合
		return DictionaryDto.getDtos(pos);
	}

}
