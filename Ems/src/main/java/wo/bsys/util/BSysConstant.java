package wo.bsys.util;

import wo.common.exception.WoResultCode;

public interface BSysConstant {
	
	String SESSION_USER = "bSysUser";

	WoResultCode ERR_LOGIN = new WoResultCode(102, "用户名或者密码不正确！");

	WoResultCode ERR_LOGIN_NOT = new WoResultCode(104, "请登录！");

	WoResultCode ERR_LOGIN_DEPT = new WoResultCode(105, "用户未关联部门！");

	WoResultCode ERR_LOGIN_ROLE = new WoResultCode(106, "用户未关联该角色！");
	
	WoResultCode ERR_CHOOSE_CLASS = new WoResultCode(500, "课表上该节次已有课");
	
	WoResultCode ERR_CHOOSE = new WoResultCode(500, "不可重复选课");
}
