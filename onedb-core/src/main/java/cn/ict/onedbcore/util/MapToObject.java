package cn.ict.onedbcore.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class MapToObject {

	public static Object mapToObject(final Map<String, Object> map, final Class<?> clazz) {
		
		if (map == null || map.size() == 0) return null;

		try {
			Object object = clazz.newInstance();
			for (String key : map.keySet()) {
				Object obj = map.get(key);
				Field field = object.getClass().getDeclaredField(key);
				field.setAccessible(true);

				if (obj instanceof ResultSet) {
					// 处理游标
					Type type = field.getGenericType();
					if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
						Type t1 = ((ParameterizedType) type).getActualTypeArguments()[0];
						List list = ResultSetDecode.resultToList((ResultSet) obj, (Class<?>) t1);
						field.set(object, list);
					}
				} else {
					// 需要考虑field 是list或者数据的情况
					field.set(object, obj);
				}
			}
			
			return object;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return null;
	}
	
}
