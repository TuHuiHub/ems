package wo.bsys.service;

import wo.bsys.vo.WoUser;

public interface CoreService {

	/**
	 * @param username
	 * @param password
	 * @param roleId
	 * @return
	 */
	WoUser authenticate(String username, String password);
}
