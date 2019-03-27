package wo.common.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 项目异常类
 * 
 */
public class WoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5680000136411496594L;

	/**
	 * Recording the log of this class.
	 */
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(WoException.class);


	private WoResultCode code = WoResultCode.getUnknownCode();

	public WoResultCode getCode() {
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return code.getMsg();
	}

	/**
	 * 
	 */
	public WoException() {
		super();
	}

	/**
	 * @param code
	 */
	public WoException(WoResultCode code, Object... args) {
		super();
		this.code = code;
		this.code.setMsgArgs(args);
	}

	/**
	 * @param code
	 */
	public WoException(Throwable cause, WoResultCode code, Object... args) {
		super(cause);
		this.code = code;
		this.code.setMsgArgs(args);
	}
}
