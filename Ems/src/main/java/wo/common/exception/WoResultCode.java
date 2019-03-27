package wo.common.exception;

import org.springframework.util.StringUtils;

public class WoResultCode {

	private String msg = "未知错误!";

	private Integer code = 0;

	public WoResultCode() {
	}

	public WoResultCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public Boolean getSuccess () {
		return code == 1;
	}
	
	public void setMsgArgs(Object... args) {
		if (args == null || args.length == 0) {
			return;
		}
		msg = String.format(msg, args);
	}

	public String getMsg() {
		return msg;
	}
	
	public String getMessage() {
		return msg;
	}

	public WoResultCode setMsg(String msg) {
		if (!StringUtils.isEmpty(msg)) {
			this.msg = msg;
		}
		return this;
	}

	private Object content = "";

	public Object getContent() {
		return content;
	}

	public WoResultCode setContent(Object content) {
		if (content != null) {
			this.content = content;
		}
		return this;
	}

	/**
	 * @return
	 */
	public WoResultCode cloneCode() {
		WoResultCode code = new WoResultCode(this.code, this.msg);
		code.setContent(this.content);
		return code;
	}

	/**
	 * @return
	 */
	public static WoResultCode getSuccessCode () {
		return new WoResultCode(1, "操作成功！");
	}

	/**
	 * @return
	 */
	public static WoResultCode getUnknownCode() {
		return new WoResultCode();
	}
}
