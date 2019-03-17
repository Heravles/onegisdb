package cn.ict.onedbcore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.SpatialOpMapper;

@Service
public class SpatialOpDao {

	@Autowired
	private SpatialOpMapper spatialOpMapper;
	
	public float geomRelaOp(String wkt_parm1, String wkt_parm2, float len, String op) {
		return spatialOpMapper.geomRelaOp(wkt_parm1, wkt_parm2, len, op);
	}
}
