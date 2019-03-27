package wo.common.util;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import wo.common.exception.WoException;

public class WoJsonUtil {
	
	
	/**
	 * Json与Object转换的操作类。
	 */
	public final static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 将Json字符串转换为指定Class类型的对象。
	 * 
	 * @param value
	 *            Json字符串。
	 * @param clazz
	 *            最终的转换类型，可以是任意Java类型。
	 * @param <T>
	 *            自定义泛型类型。
	 * @return 指定类型的对象。
	 */
	public static <T> T readAsType(String value, Class<T> clazz) {
		T type = null;
		try {
			type = mapper.readValue(value, clazz);
		} catch (IOException e) {
			throw new WoException(e, WoConstant.ERR_JSON_OBJ);
		}
		return type;
	}

	/**
	 * @param json
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> readAsList (String json, Class<T> cls) {
		JavaType javaType = getCollectionType(ArrayList.class, cls);
		try {
			return (List<T>) mapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new WoException(e, WoConstant.ERR_JSON_LIST);
		}
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
	
	/**
	 * @param w
	 * @param value
	 */
	public static void write (Writer w, Object value) {
		try {
			mapper.writeValue(w, value);
		} catch (Exception e) {
			throw new WoException(e, WoConstant.ERR_JSON_WRITER);
		}
	}
	
	/**
	 * 对象转化为字符串
	 * @param val
	 * @return
	 */
	public static String toString (Object val) {
		try {
			return mapper.writeValueAsString(val);
		} catch (JsonProcessingException e) {
			throw new WoException(e, WoConstant.ERR_JSON_WRITER);
		}
	}
}
