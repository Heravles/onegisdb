package cn.ict.onedbcore.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.GeoOpMapper;
import cn.ict.onedbcore.model.GeoOpResult;
import cn.ict.onedbcore.util.MapToObject;

@Service
public class GeoOpDao {

	@Autowired
	private GeoOpMapper geoOpMapper;

	public List<GeoOpResult> getObjectByGeom(String wkt, String op, int srsid, Timestamp timefilter){
		List<Map<String, Object>> resultMaps = geoOpMapper.getObjectByGeom(wkt, op, srsid, timefilter);
		List<GeoOpResult> geoOpResults = new ArrayList<>();
		for (Map<String, Object> resultMap : resultMaps) {
			GeoOpResult geoOpResult = (GeoOpResult)MapToObject.mapToObject(resultMap, GeoOpResult.class);
			geoOpResults.add(geoOpResult);
		}
		return geoOpResults;
	}

}
