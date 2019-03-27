package wo.bsys.util;

import java.util.Map;

import wo.bsys.vo.WoUser;
import wo.common.exception.WoException;

public class BSysUtil {
	
	/**
	 * 获取当前用户信息
	 * @param map controller方法中传入的参数
	 * @return
	 */
	public static WoUser getCurrentUser (Map<String, Object>map) {
		WoUser u = (WoUser)map.get(BSysConstant.SESSION_USER);
		if (u == null) {
			throw new WoException (BSysConstant.ERR_LOGIN);
		}
		return u;
	}
}
