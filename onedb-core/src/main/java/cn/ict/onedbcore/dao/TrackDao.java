package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.TrackData;
import cn.ict.onedbcore.mapper.TrackMapper;
import cn.ict.onedbcore.mapper.TrackResultMapper;
import cn.ict.onedbcore.model.TrackDataResult;
import cn.ict.onedbcore.util.MapToObject;

@Service
public class TrackDao {

	@Autowired
	TrackMapper trackMapper;

	@Autowired
	TrackResultMapper trackResultMapper;
	
	public List<TrackData> saveAll(Collection<TrackData> lists){
		List<TrackData> resultList = new ArrayList<>();
		trackMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}

	public List<TrackDataResult> queryTrackById(long id) {
		System.out.println(id);
		List<Map<String, Object>> resultMaps = trackResultMapper.querytrackById(id);
		System.out.println(resultMaps);
		return transfer(resultMaps);
	}

	public List<TrackDataResult> queryTrackByIdAndTS(
			String id, long begintime, long endtime, String wkt, long trs, long srs) {
		System.out.println(wkt);
		List<Map<String, Object>> resultMaps = 
				trackResultMapper.querytrackByIdAndTS(id, begintime, endtime, 
						wkt, trs, srs);
		return transfer(resultMaps);
	}
	

	public static List<TrackDataResult> transfer(List<Map<String, Object>> resultMaps){
		List<TrackDataResult> results = new ArrayList<>();
		for (Map<String, Object> resultMap : resultMaps) {
			TrackDataResult result = (TrackDataResult)MapToObject.mapToObject(resultMap, TrackDataResult.class);
			results.add(result);
		}
		return results;
	}
}
