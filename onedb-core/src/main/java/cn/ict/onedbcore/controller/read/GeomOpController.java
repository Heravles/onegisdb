package cn.ict.onedbcore.controller.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.GeoOpDao;

@RestController
@RequestMapping("/api/read/geom")
public class GeomOpController {

	@Autowired
	private GeoOpDao geoOpDao;

	@RequestMapping(method = RequestMethod.GET, value = "/contains/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Contains(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Contains(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/intersect/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Intersects(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Intersects(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/overlaps/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Overlaps(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Overlaps(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/touches/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Touches(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Touches(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/distance/wkt1/{wkt1}/wkt2/{wkt2}")
	public Double Distance(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Distance(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dwithin/wkt1/{wkt1}/wkt2/{wkt2}/dis/{dis}")
	public Integer DWithin(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2,
			@PathVariable(value = "dis") double dis) {
		return geoOpDao.DWithin(wkt1, wkt2, dis);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/equals/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Equals(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Equals(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/disjoint/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Disjoint(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Disjoint(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/crosses/wkt1/{wkt1}/wkt2/{wkt2}")
	public Integer Crosses(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Crosses(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/area/wkt/{wkt}")
	public Double Area(@PathVariable(value = "wkt") String wkt) {
		return geoOpDao.Area(wkt);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/length/wkt/{wkt}")
	public Double Length(@PathVariable(value = "wkt") String wkt) {
		return geoOpDao.Length(wkt);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/centroid/wkt/{wkt}")
	public String Centroid(@PathVariable(value = "wkt") String wkt) {
		return geoOpDao.Centroid(wkt);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/union/wkt1/{wkt1}/wkt2/{wkt2}")
	public String Union(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Union(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/intersection/wkt1/{wkt1}/wkt2/{wkt2}")
	public String Intersection(@PathVariable(value = "wkt1") String wkt1,
			@PathVariable(value = "wkt2") String wkt2) {
		return geoOpDao.Intersection(wkt1, wkt2);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/isclosed/wkt/{wkt}")
	public Integer IsClosed(@PathVariable(value = "wkt") String wkt) {
		return geoOpDao.IsClosed(wkt);
	}

}
