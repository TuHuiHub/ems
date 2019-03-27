package wo.common.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WoExceptionHandler {
	private final static Logger LOG = LogManager.getLogger(WoExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleError(Exception exception) {
		LOG.info("", exception);
//		if (exception instanceof UnauthorizedException) {
//			return WoResultCode.getUnknownCode().setMsg("用户未授权！");
//		}
		if (exception instanceof WoException) {
			return ((WoException)exception).getCode();
		}
		if (exception.getCause() instanceof WoException) {
			return ((WoException)exception.getCause()).getCode();
		}
		return WoResultCode.getUnknownCode().setMsg("操作失败！");
	}
}
