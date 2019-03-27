package wo.bsys.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import wo.bsys.dto.RoleDto;
import wo.bsys.po.Role;
import wo.bsys.repository.RoleRepository;
import wo.bsys.service.RoleService;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

/**
 * PO实体Role对应的Service接口实现类.
 * @author 
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {


	/**
	 * 注入RoleRepository.
	 */
	@Resource // @Autowired
	private RoleRepository roleRepository;

	/**
	 * DataTable获取角色列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<RoleDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<Role> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = roleRepository.findAll(pageInput);
		} else {
			pageData = roleRepository.findAllBynameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<RoleDto> pr = RoleDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建角色
	 * @param dto
	 */
	@Override
	public void create(RoleDto dto) {
		Role po = dto.createPO();
		roleRepository.save(po);
	}

	/**
	 * 根据id获取角色数据
	 * @param id
	 * @return
	 */
	@Override
	public RoleDto getById(String id) {
		Role po = roleRepository.findById(id).get();
		return new RoleDto (po);
	}

	/**
	 * 修改角色
	 * @param dto
	 */
	@Override
	public void update(RoleDto dto) {
		Role po = roleRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个角色
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		roleRepository.deleteByIdIn(id);
	}

}
