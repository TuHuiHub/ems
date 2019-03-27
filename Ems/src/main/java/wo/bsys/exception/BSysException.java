package wo.bsys.exception;

import wo.common.exception.WoException;
import wo.common.exception.WoResultCode;

/**
 * BSys系统管理异常类
 * @author 
 *
 */
public class BSysException extends WoException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3727381830140959071L;

	public BSysException() {
	}

	public BSysException(WoResultCode code, Object... args) {
		super(code, args);
	}

	public BSysException(Throwable cause, WoResultCode code, Object... args) {
		super(cause, code, args);
	}
}
