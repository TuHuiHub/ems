package wo.common.util;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;

import wo.common.exception.WoException;

public class WoUtil {
	
	private final static Logger LOG = LogManager.getLogger(WoUtil.class);
	
	/**
	 * @param obj
	 * @return
	 */
	public static Boolean isEmpty (Object obj) {
		return StringUtils.isEmpty(obj);
	}
	
	/**
	 * 把id字符串解析为非null字符串数组。
	 * @param strIds 以逗号隔开的id字符串
	 * @return
	 */
	public static String[] splitIds (String strIds) {
		String[] ids = new String[0];
		if (!WoUtil.isEmpty(strIds)) {
			ids = strIds.split(",");
		}
		return ids;
	}
	
	/**
	 * 获取value对应的模糊匹配表达式，例如：value是'vvv'，则表达式为'%vvv%'
	 * @param value
	 * @return
	 */
	public static String getLikeValue (String value) {
		String val = "%";
		if (!WoUtil.isEmpty(value)) {
			val = "%" + value + "%";
		}
		return val;
	}
	
	/**
	 * if len is 4 and idx is 23 then re is 0023.
	 * 
	 * @param len
	 * @param idx
	 * @return re
	 */
	public static String generateFixedLenNo(int len, int idx) {
		return String.format("%0" + len + "d", idx);
		/*String re = String.valueOf(idx);
		if (re.length() >= len) {
			return re.substring(0, len);
		}
		len = len - re.length();
		for (int i = 0; i < len; i++) {
			re = '0' + re;
		}
		return re;*/
	}
	
	/**
	 * 生成uuid
	 * @return
	 */
	public static String uuid () {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * @param objs
	 * @param obj
	 * @return
	 */
	public static Boolean contains (Object[] objs, Object obj) {
		if (objs == null || objs.length == 0) {
			return false;
		}
		for (Object o : objs) {
			if (o.equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param name
	 * @param cls
	 * @return
	 */
	public static <T> T getBean (String name, Class<T> cls) {
		// bean名称：woSceneRoleExtension + bean类型：IRoleExtensionService
		return ContextLoader.getCurrentWebApplicationContext().getBean(name, cls);
	}
	
	/**
	 * @param name
	 * @param cls
	 * @return
	 */
	public static <T> T getBean (Class<T> cls) {
		// bean名称：woSceneRoleExtension + bean类型：IRoleExtensionService
		return ContextLoader.getCurrentWebApplicationContext().getBean(cls);
	}
	
	/**
	 * 将字符串s首字符转化为大写.
	 * @param s
	 * @return
	 */
	public static String getUpperFirstChar (String s) {
		char[] cs = s.toCharArray();
		if (cs[0] >= 'a' && cs[0] <='z') {
			cs[0] -= ('a' - 'A');
		}
		return String.valueOf(cs);
	}
	
	/**
	 * 将字符串s首字符转化为小写.
	 * @param s
	 * @return
	 */
	public static String getLowerFirstChar (String s) {
		char[] cs = s.toCharArray();
		if (cs[0] >= 'A' && cs[0] <='Z') {
			cs[0] += ('a' - 'A');
		}
		return String.valueOf(cs);
	}
	
	/**
	 * 获取文件分隔符结尾的目录路径.
	 * @param dir
	 * @return
	 */
	public static String getDirEndWithFileSeparator (String dir) {
    	if (dir.endsWith("/") || dir.endsWith("\\")) {
    		return dir;
    	}
    	return dir + File.separator;
    }
	
	/**
	 * 将字符串通过MD5算法散列化
	 * @param salt
	 * @param str
	 * @return
	 */
	public static String getMD5(String salt, String str) {
		if (WoUtil.isEmpty(salt)) {
			throw new WoException (WoConstant.ERR_MD5_SALT);
		}
		if (WoUtil.isEmpty(str)) {
			throw new WoException (WoConstant.ERR_MD5_STR);
		}
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");// MD5 SHA-256...
            // 计算md5函数
            md.update((salt + str).getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
        	throw new WoException (e, WoConstant.ERR_MD5);
        }
    }
	
	public static void main (String[] args) {
		LOG.info(getMD5("test1", "123456"));
	}
}
