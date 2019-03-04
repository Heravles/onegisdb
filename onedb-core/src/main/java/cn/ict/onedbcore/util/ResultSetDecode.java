package cn.ict.onedbcore.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;



public class ResultSetDecode {
	
	public static List resultToList(ResultSet resultSet, final Class<?> clazz){
		try {
			ResultSetMetaData rsmd = resultSet.getMetaData();
			JSONArray jsonArray = new JSONArray();
			while(resultSet.next()) {
				int numColumns = rsmd.getColumnCount();
				JSONObject jsonObject = new JSONObject();
				for (int i = 0; i < numColumns; i++) {
					String column_name = rsmd.getColumnName(i + 1);
					jsonObject.put(column_name, resultSet.getObject(i + 1));
				}
				jsonArray.put(jsonObject);
			}
			String string = jsonArray.toString();
			List list = com.alibaba.fastjson.JSONObject.parseArray(string, clazz);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
