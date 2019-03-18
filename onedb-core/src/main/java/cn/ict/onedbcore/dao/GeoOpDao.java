package cn.ict.onedbcore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.GeoOpMapper;

@Service
public class GeoOpDao {

	@Autowired
	private GeoOpMapper geoOpMapper;
	
	public Integer Contains(String wkt1, String wkt2) {
		return geoOpMapper.Contains(wkt1, wkt2);
	}
	
	public Integer Intersects(String wkt1, String wkt2) {
		return geoOpMapper.Intersects(wkt1, wkt2);
	}

	public Integer Overlaps(String wkt1, String wkt2) {
		return geoOpMapper.Overlaps(wkt1, wkt2);
	}

	public Integer Touches(String wkt1, String wkt2) {
		return geoOpMapper.Touches(wkt1, wkt2);
	}

	public Double Distance(String wkt1, String wkt2) {
		return geoOpMapper.Distance(wkt1, wkt2);
	}

	public Integer DWithin(String wkt1, String wkt2, double dis) {
		return geoOpMapper.DWithin(wkt1, wkt2, dis);
	}

	public Integer Equals(String wkt1, String wkt2) {
		return geoOpMapper.Equals(wkt1, wkt2);
	}

	public Integer Disjoint(String wkt1, String wkt2) {
		return geoOpMapper.Disjoint(wkt1, wkt2);
	}

	public Integer Crosses(String wkt1, String wkt2) {
		return geoOpMapper.Crosses(wkt1, wkt2);
	}

	public Double Area(String wkt1) {
		return geoOpMapper.Area(wkt1);
	}

	public Double Length(String wkt1) {
		return geoOpMapper.Length(wkt1);
	}

	public String Centroid(String wkt1) {
		return geoOpMapper.Centroid(wkt1);
	}

	public String Union(String wkt1, String wkt2) {
		return geoOpMapper.Union(wkt1, wkt2);
	}
	
	public String Intersection(String wkt1,	String wkt2) {
		return geoOpMapper.Intersection(wkt1, wkt2);
	}
	
	public Integer IsClosed(String wkt1) {
		return geoOpMapper.IsClosed(wkt1);
	}

}
