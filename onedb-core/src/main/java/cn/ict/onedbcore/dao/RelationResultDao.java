package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.RelationResultMapper;
import cn.ict.onedbcore.model.RelationResult;
import cn.ict.onedbcore.util.MapToObject;

@Service
public class RelationResultDao {

	@Autowired
	private RelationResultMapper relationResultMapper;
	
	public List<RelationResult> queryByIdAndDep(long id, int dep) {
		List<Map<String, Object>> resultMaps = relationResultMapper.queryByIdAndDep(id, dep);
		return transfer(resultMaps);
	}
	

	public static List<RelationResult> transfer(List<Map<String, Object>> resultMaps){
		List<RelationResult> results = new ArrayList<>();
		for (Map<String, Object> resultMap : resultMaps) {
			RelationResult result = (RelationResult)MapToObject.mapToObject(resultMap, RelationResult.class);
			results.add(result);
		}
		return results;
	}
}
