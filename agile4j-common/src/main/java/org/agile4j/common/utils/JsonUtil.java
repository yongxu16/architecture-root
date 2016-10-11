package org.agile4j.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 給予jackson的json工具類
 * 
 * @author hanyx
 */
public final class JsonUtil {

	public static String object2Str(Object obj) {
		ObjectMapper mapper = new ObjectMapper() ;
		String result = "";
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> T str2Object(String str, Class<T> clz) {
		T obj = null ;
		ObjectMapper mapper = new ObjectMapper() ;
		try {
			obj = mapper.readValue(str, clz) ;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
}
