package cn.ict.onedbcore.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.FeaturesMapper;

@Service
public class FeaturesDao {

	@Autowired
	private FeaturesMapper featuresMapper;

	public List<Map<String, Object>> getObjBaseInfo() {
		List<Map<String, Object>> resultMaps = featuresMapper.getObjectBaseInfo();
		return resultMaps;
	}
	
	public List<Long> getSubObjId(int id){
		return featuresMapper.getSubObjectId(id);
	}
	
	public Long getParentId(int id){
		return featuresMapper.getParentObjId(id);
	}
	
	public List<Long> getObjIdByPage(int pageNum, int pageSize, int orderType, boolean descOrAsc){
		return featuresMapper.getObjIdByPage(pageNum, pageSize, orderType, descOrAsc);
	}
	
	public List<Long> getObjIdByPageAndTime(int pageNum, int pageSize, 
											int orderType, boolean descOrAsc,
											Timestamp timefilter){
		return featuresMapper.getObjIdByPageAndTime(pageNum, pageSize, orderType, descOrAsc, timefilter);
	}
}
