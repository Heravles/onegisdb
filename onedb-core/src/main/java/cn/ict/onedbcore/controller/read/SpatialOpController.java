package cn.ict.onedbcore.controller.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.SpatialOpDao;

@RestController
@RequestMapping("/api/spatial")
public class SpatialOpController {

	@Autowired
	private SpatialOpDao spatialOpDao;
	
	public static final String DISTANCE = "Distance";
	public static final String DWITHIN = "DWithin";
	public static final String EQUALS = "Equals";
	public static final String DISJOINT = "Disjoint";
	public static final String INSTERSECTS = "Intersects";
	public static final String TOUCHES = "Touches";
	public static final String CROSSES = "Crosses";
	public static final String CONTAINS = "Contains";
	public static final String OVERLAPS = "Overlaps";
	public static final String COVERS = "Covers";

	@RequestMapping(value = "/distance", method = RequestMethod.POST)
	public float getDistance(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, DISTANCE);
	}
	
	@RequestMapping(value = "/dwithin", method = RequestMethod.POST)
	public float getDWithin(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2, 
			@RequestParam(value = "len", required = true) float len) {
		return handler(wkt1, wkt2, len, DWITHIN);
	}
	
	
	@RequestMapping(value = "/equals", method = RequestMethod.POST)
	public float getEquals(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, EQUALS);
	}
	
	@RequestMapping(value = "/disjoint", method = RequestMethod.POST)
	public float getDisjoint(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, DISJOINT);
	}
	
	
	@RequestMapping(value = "/intersects", method = RequestMethod.POST)
	public float getIntersects(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, INSTERSECTS);
	}
	
	
	@RequestMapping(value = "/touches", method = RequestMethod.POST)
	public float getTouches(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, TOUCHES);
	}
	
	
	@RequestMapping(value = "/crosses", method = RequestMethod.POST)
	public float getCrosses(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, CROSSES);
	}
	
	
	@RequestMapping(value = "/contains", method = RequestMethod.POST)
	public float getContains(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, CONTAINS);
	}
	
	
	@RequestMapping(value = "/overlaps", method = RequestMethod.POST)
	public float getOverlaps(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, OVERLAPS);
	}
	
	
	@RequestMapping(value = "/covers", method = RequestMethod.POST)
	public float getCovers(@RequestParam(value = "wkt1", required = true) String wkt1, 
			@RequestParam(value = "wkt2", required = true) String wkt2) {
		return handler(wkt1, wkt2, 0, COVERS);
	}
	
	private float handler(String wkt1, String wkt2, float len, String op) {
		return spatialOpDao.geomRelaOp(wkt1, wkt2, len, op);
	}

}
