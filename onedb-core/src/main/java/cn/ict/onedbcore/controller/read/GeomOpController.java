package cn.ict.onedbcore.controller.read;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.GeoOpDao;
import cn.ict.onedbcore.model.GeoOpResult;

@RestController
@RequestMapping("/api/geom")
public class GeomOpController {

	@Autowired
	private GeoOpDao geoOpDao;
	
	public static final String DISJOINT = "Disjoint";
	public static final String INTERSECTS = "Intersects";
	public static final String TOUCHES = "Touches";
	public static final String CROSSES = "Crosses";
	public static final String CONTAINS = "Contains";
	public static final String OVERLAPS = "Overlaps";
	public static final String EQUALS = "Equals";

	@RequestMapping(value = "/disjoint", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomDisjoint(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, DISJOINT, srsid, time);
	}
	
	@RequestMapping(value = "/intersects", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomIntersects(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, INTERSECTS, srsid, time);
	}
	
	@RequestMapping(value = "/touches", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomInTouches(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, TOUCHES, srsid, time);
	}
	
	@RequestMapping(value = "/crosses", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomCrosses(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, CROSSES, srsid, time);
	}
	
	@RequestMapping(value = "/contains", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomContains(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, CONTAINS, srsid, time);
	}
	
	@RequestMapping(value = "/overlaps", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomOverlaps(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, OVERLAPS, srsid, time);
	}
	
	@RequestMapping(value = "/equals", method = RequestMethod.POST)
	public List<GeoOpResult> getObjectByGeomEqualsWithTime(@RequestParam(value = "wkt", required = true) String wkt,
			@RequestParam(value = "srsid", required = true) int srsid,
			@RequestParam(value = "time", required = true) String time){
		return handler(wkt, EQUALS, srsid, time);
	}

	private List<GeoOpResult> handler(String wkt, String op, int srsid, String time){
		System.out.println(time);
		if (time.equals("null"))
			return geoOpDao.getObjectByGeom(wkt, op, srsid, null);
		Timestamp timefilter = Timestamp.valueOf(time);
		return geoOpDao.getObjectByGeom(wkt, op, srsid, timefilter);
	}
}
