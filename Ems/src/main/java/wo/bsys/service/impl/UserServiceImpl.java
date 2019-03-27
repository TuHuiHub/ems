package wo.bsys.service.impl;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import wo.bsys.dto.UserDto;
import wo.bsys.po.Role;
import wo.bsys.po.User;
import wo.bsys.repository.UserRepository;
import wo.bsys.service.UserService;
import wo.bsys.vo.WoUser;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

/**
 * PO实体User对应的Service接口实现类.
 * @author 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {


	/**
	 * 注入UserRepository.
	 */
	@Resource // @Autowired
	private UserRepository userRepository;

	/**
	 * DataTable获取用户列表数据.
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@Override
	public WoPage<UserDto> getPageData(Long start, Long length, String searchContent, String dir) {
		// 从dao获取数据
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue()
			 );
		Page<User> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = userRepository.findAll(pageInput);
		} else {
			pageData = userRepository.findAllByloginNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<UserDto> pr = UserDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}

	/**
	 * 创建用户
	 * @param dto
	 */
	@Override
	public void create(UserDto dto) {
		User po = dto.createPO();
		userRepository.save(po);
	}

	/**
	 * 根据id获取用户数据
	 * @param id
	 * @return
	 */
	@Override
	public UserDto getById(String id) {
		User po = userRepository.findById(id).get();
		return new UserDto (po);
	}

	/**
	 * 修改用户
	 * @param dto
	 */
	@Override
	public void update(UserDto dto) {
		User po = userRepository.findById(dto.getId()).get();
		dto.updatePO(po);
	}

	/**
	 * 根据id数组删除一个或者多个用户
	 * @param id
	 */
	@Override
	public void delete(String[] id) {
		userRepository.deleteByIdIn(id);
	}

	@Override
	public void updatePassword(UserDto dto) {
		// TODO Auto-generated method stub
		User po = userRepository.findById(dto.getId()).get();
		po.setPasswordTime(new Date());
		po.setPassword(dto.getPassword());
		userRepository.save(po);
	}


	@Override
	public void update(WoUser user) {
		User u = new User();
		u.setCreateTime(user.getCreateTime());
		u.setId(user.getId());
		u.setLoginName(user.getLoginName());
		u.setPasswordTime(new Date());
		u.setPassword(user.getPassword());
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		String id = user.getRolesId();
		role.setId(id);
		roles.add(role);
		u.setRoles(roles );
		userRepository.save(u);
	}

}
