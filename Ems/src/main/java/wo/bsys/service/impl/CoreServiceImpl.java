package wo.bsys.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import wo.bsys.exception.BSysException;
import wo.bsys.po.Menu;
import wo.bsys.po.Role;
import wo.bsys.po.User;
import wo.bsys.repository.MenuRepository;
import wo.bsys.repository.UserRepository;
import wo.bsys.service.CoreService;
import wo.bsys.util.BSysConstant;
import wo.bsys.vo.WoMenu;
import wo.bsys.vo.WoUser;
import wo.common.util.WoUtil;

/**
 * @author 
 */
@Service
@Transactional
public class CoreServiceImpl implements CoreService {

	private final static Logger LOG = LogManager.getLogger(CoreServiceImpl.class);

	/**
	 * 注入UserRepository.
	 */
	@Resource // @Autowired
	private UserRepository userRepository;

	/**
	 * 注入MenuRepository.
	 */
	@Resource // @Autowired
	private MenuRepository menuRepository;

	/**
	 * 将menus中的顶级菜单取出为集合，并将其他菜单放入顶级菜单的子菜单集合中
	 * @param menus
	 * @return
	 */
	private static List<WoMenu> getTops (List<Menu> menus) {
		Collections.sort(menus, new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				// TODO Auto-generated method stub
				return o1.getNo().compareTo(o2.getNo());
			}});
		List<WoMenu> results = new ArrayList<WoMenu>();
		for (Menu m : menus) {
			if (m.getParent() == null) {
				Boolean active = results.size() == 0;
				results.add(new WoMenu(m, active));
			} else {
				WoMenu lastTop = results.get(results.size() - 1);
				Boolean active = results.size() == 1 && lastTop.getChildren().size() == 0;
				lastTop.getChildren().add(new WoMenu(m, active));
			}
		}
		return results;
	}
	
	@Override
	public WoUser authenticate(String user, String password) {
		User u = userRepository.findByLoginName(user);
		LOG.info("user:" + user);
		if (u == null) {
			throw new BSysException(BSysConstant.ERR_LOGIN);
		}
		// u.setRoles(roleDao.findAllByUserId(u.getId()));
		LOG.info("authenticate-roles:" + u.getRoles().size());
		if (password != null) {
			// 验证密码
			String md5 = WoUtil.getMD5(u.getId(), password);
			LOG.info(md5);
			if (!md5.equals(u.getPassword())) {
				throw new BSysException(BSysConstant.ERR_LOGIN);
			}
		}
		List<String> roleIds = new ArrayList<String>();
		for (Role r : u.getRoles()) {
			roleIds.add(r.getId());
		}
		// 获取当前用户有权限的菜单数据
		// List<Menu> allTopMenus = menuRepository.findAllByParentIdIsNullOrderByNo();
		List<Menu> permittedMenus = null;
		permittedMenus = menuRepository.findAllMenusByRoleIds(roleIds);
		List<WoMenu> menus = getTops(permittedMenus);
		// 构造session中的用户信息，并设置菜单数据
		WoUser woUser = new WoUser(u);
		woUser.setMenus(menus);
		LOG.info("用户【" + woUser.getLoginName() + "】验证通过...");
		return woUser;
	}
	
	public static void main(String[] args) {
		List<Menu> ms = new ArrayList<Menu>();
		Menu m = new Menu ();
		m.setNo("01");
		ms.add(m);
		m = new Menu ();
		m.setNo("00");
		ms.add(m);
		m = new Menu ();
		m.setNo("0001");
		ms.add(m);
		m = new Menu ();
		m.setNo("0111");
		ms.add(m);
		Collections.sort(ms, new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				// TODO Auto-generated method stub
				return o1.getNo().compareTo(o2.getNo());
			}});
		for (Menu m1 : ms) {
			LOG.info(m1.getNo());
		}
	}
}
