package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.ActionResultMapper;
import cn.ict.onedbcore.model.obj.ActionResult;
import cn.ict.onedbcore.util.MapToObject;

@Service
public class ActionResultDao {

	@Autowired
	private ActionResultMapper actionResultMapper;
	
	public List<ActionResult> queryById(String qids) {
		List<Map<String, Object>> resultMaps = actionResultMapper.queryByIds(qids);
		return transfer(resultMaps);
	}
	

	public static List<ActionResult> transfer(List<Map<String, Object>> resultMaps){
		List<ActionResult> attrResults = new ArrayList<>();
		for (Map<String, Object> resultMap : resultMaps) {
			ActionResult attrResult = (ActionResult)MapToObject.mapToObject(resultMap, ActionResult.class);
			attrResults.add(attrResult);
		}
		return attrResults;
	}
}
