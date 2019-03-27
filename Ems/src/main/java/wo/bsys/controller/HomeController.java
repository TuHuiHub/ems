package wo.bsys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import wo.bsys.service.CoreService;
import wo.bsys.util.BSysConstant;
import wo.bsys.util.BSysUtil;
import wo.bsys.vo.WoMenu;
import wo.bsys.vo.WoUser;

@Controller
@SessionAttributes(BSysConstant.SESSION_USER)
public class HomeController {
	
	@RequestMapping("/")
	String toMain (String menu, Map<String, Object> map) {
		try {
			WoUser u = BSysUtil.getCurrentUser(map);
			if (menu != null) {
				for (WoMenu m : u.getMenus()) {
					for (WoMenu c : m.getChildren()) {
						if (c.getActive()) {
							if (c.getId().equals(menu)) {
								break;
							}
							c.setActive(false);
							m.setActive(false);
						} else if (c.getId().equals(menu)) {
							c.setActive(true);
							m.setActive(true);
						}
					}
				}
			}
			return "main";
		} catch (Exception e) {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/login")
	String login () {
		return "login";
	}
	
	@Resource // @Autowired
	private CoreService coreService;
	
	@PostMapping("/login")
	String login (String username, String password, Map<String, Object>map) {
		try {
			WoUser u = this.coreService.authenticate(username, password);
			map.put(BSysConstant.SESSION_USER, u);
			return "redirect:/";
		} catch (Exception e) {
			map.put("error", "验证失败...");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	String logout (Map<String, Object> map, SessionStatus status) {
		map.remove(BSysConstant.SESSION_USER);
		status.setComplete();
		return "redirect:/";
	}
}
