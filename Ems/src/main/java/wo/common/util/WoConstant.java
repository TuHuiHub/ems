package wo.common.util;


import wo.common.exception.WoResultCode;

public class WoConstant {


	public final static String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

	public final static String FORMAT_DATE = "yyyy-MM-dd";

	public final static WoResultCode ERR_JSON_WRITER = new WoResultCode(9, "对象转化为JSON写入出错！");
	public final static WoResultCode ERR_JSON_OBJ = new WoResultCode(10, "JSON转化为对象出错！");
	public final static WoResultCode ERR_JSON_LIST = new WoResultCode(11, "JSON转化为列表对象出错！");

	public final static WoResultCode ERR_MULTIPLE = new WoResultCode(10, "查询结果多于一个！");

	public final static WoResultCode ERR_MD5_SALT = new WoResultCode(14, "Salt不能为空！");
	public final static WoResultCode ERR_MD5_STR = new WoResultCode(15, "字符串不能为空！");
	public final static WoResultCode ERR_MD5 = new WoResultCode(16, "字符串MD5处理失败！");
	
	public final static WoResultCode ERR_CLASS = new WoResultCode(20, "找不到类:[%s]！");
	
	public final static WoResultCode ERROR_VELOCITY_NULL = new WoResultCode(40, "模板引擎不能为空！");
	public final static WoResultCode ERROR_VELOCITY_TMPL = new WoResultCode(41, "获取模板[%s]异常！");
	public final static WoResultCode ERROR_VELOCITY_TMPL_STR = new WoResultCode(42, "将模板[%s]转化为字符串时出错！");
	public final static WoResultCode ERROR_VELOCITY_TMPL_OUTSTREAM = new WoResultCode(43, "将模板[%s]转化为输出流时出错！");
	public final static WoResultCode ERROR_VELOCITY_TMPL_FILE_EXIST = new WoResultCode(44, "模板[%s]转化的目标文件[%s]不存在！");
	public final static WoResultCode ERROR_VELOCITY_TMPL_FILE = new WoResultCode(45, "将模板[%s]转化为文件[%s]时出错！");
	public final static WoResultCode ERROR_VELOCITY_PROP = new WoResultCode(46, "设置模板引擎参数时出错！");
	public final static WoResultCode ERROR_VELOCITY_TMPLSTR = new WoResultCode(47, "解析模板字符串[%s]时出错！");
	public final static WoResultCode ERROR_VELOCITY_DIR = new WoResultCode(48, "获取模板文件目录出错！");
}
