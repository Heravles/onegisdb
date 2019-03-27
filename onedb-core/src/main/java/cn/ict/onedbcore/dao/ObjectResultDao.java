package cn.ict.onedbcore.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.ObjectResultMapper;
import cn.ict.onedbcore.model.ObjectResult;
import cn.ict.onedbcore.util.MapToObject;

@Service
public class ObjectResultDao {

	@Autowired
	private ObjectResultMapper objectResultMapper;

	public List<ObjectResult> queryByDomain(long sdomain) {
		List<Map<String, Object>> resultMaps = objectResultMapper.queryByDomain(sdomain);
		return transfer(resultMaps);
	}
	
	public List<ObjectResult> queryById(long id) {
		List<Map<String, Object>> resultMaps = objectResultMapper.queryById(id);
		return transfer(resultMaps);
	}
	
	public List<ObjectResult> queryByIdAndTS(String id, long begintime, long endtime, String wkt, 
			long trs, long srs) {
		List<Map<String, Object>> resultMaps = 
				objectResultMapper.queryByIdAndNameAndTS(id, null
				, begintime, endtime, wkt, trs, srs);
		return transfer(resultMaps);
	}
	
	public List<ObjectResult> queryByName(String name) {
		List<Map<String, Object>> resultMaps = objectResultMapper.queryByName(name);
		return transfer(resultMaps);
	}

	public List<ObjectResult> queryByNameAndTS(String name, long begintime, long endtime, String wkt, 
			long trs, long srs) {
		List<Map<String, Object>> resultMaps = 
				objectResultMapper.queryByIdAndNameAndTS(null, name
				, begintime, endtime, wkt, trs, srs);
		return transfer(resultMaps);
	}

	public List<ObjectResult> queryByIdAndName(long id, String name) {
		List<Map<String, Object>> resultMaps = objectResultMapper.queryByIdAndName(id, name);
		return transfer(resultMaps);
	}
	
	public List<ObjectResult> queryByIdAndNameAndTS(String id, String name, long begintime, 
			long endtime, String wkt, long trs, long srs) {
		List<Map<String, Object>> resultMaps = objectResultMapper.queryByIdAndNameAndTS(id, name
				, begintime, endtime, wkt, trs, srs);
		return transfer(resultMaps);
	}
	
	public Long getCount() {
		return objectResultMapper.getCount();
	}
	
	public void updateGeom() {
		objectResultMapper.updateGeom();
	}
	
	public ObjectResult getById(int id) {
		Map<String, Object> resultMap = objectResultMapper.getById(id);
		return (ObjectResult)MapToObject.mapToObject(resultMap, ObjectResult.class);
	}
	
	public List<ObjectResult> getAllByPage(int pageNum, int pageSize, int orderType, boolean descOrAsc){
		List<Map<String, Object>> resultMaps = objectResultMapper.getAllByPage(pageNum, pageSize, orderType, descOrAsc);
		return transfer(resultMaps);
	}
	
	public List<ObjectResult> getAllByPageAndTime(int pageNum, int pageSize, int orderType, boolean descOrAsc, Timestamp timefilter){
		List<Map<String, Object>> resultMaps = objectResultMapper.getAllByTimeAndPage(pageNum, pageSize, orderType, descOrAsc, timefilter);
		return transfer(resultMaps);
	}

	public List<ObjectResult> getAllByTimeAndCondAndPage(Integer pageNum, Integer pageSize, Integer orderType,
			Boolean descOrAsc, Timestamp timefilter, String condName, String condType) {
		List<Map<String, Object>> resultMaps = objectResultMapper.getAllByTimeAndCondAndPage(
				pageNum, pageSize, orderType, descOrAsc, timefilter, condName, condType);
		return transfer(resultMaps);
	}

	public static List<ObjectResult> transfer(List<Map<String, Object>> resultMaps){
		List<ObjectResult> attrResults = new ArrayList<>();
		for (Map<String, Object> resultMap : resultMaps) {
			ObjectResult attrResult = (ObjectResult)MapToObject.mapToObject(resultMap, ObjectResult.class);
			attrResults.add(attrResult);
		}
		return attrResults;
	}
}
