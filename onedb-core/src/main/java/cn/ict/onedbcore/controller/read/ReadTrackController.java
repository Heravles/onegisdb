package cn.ict.onedbcore.controller.read;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.TrackDao;
import cn.ict.onedbcore.model.TrackDataResult;

@RestController
@RequestMapping("/api/read")
public class ReadTrackController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private TrackDao trackDao;

	@RequestMapping(value = "/track/id/{id}")
	public List<TrackDataResult> queryTrackById(@PathVariable(value = "id") String id) {
		List<TrackDataResult> result = trackDao.queryTrackById(Long.valueOf(id).longValue());
		return result;
	}

	@RequestMapping(value = "/track/begintime/{begintime}/endtime/{endtime}"
			+ "/wkt/{wkt}/trs/{trs}/srs/{srs}")
	public List<TrackDataResult> queryTrackByTS(
			@PathVariable(value = "begintime") String begintime,
			@PathVariable(value = "endtime") String endtime,
			@PathVariable(value = "wkt") String wkt,
			@PathVariable(value = "trs") String trs,
			@PathVariable(value = "srs") String srs) {
		List<TrackDataResult> result = trackDao.queryTrackByIdAndTS("0",
				Long.valueOf(begintime).longValue(), 
				Long.valueOf(endtime).longValue(), wkt, 1, 1);
		return result;
	}
	
	@RequestMapping(value = "/track/id/{id}/begintime/{begintime}/endtime/{endtime}"
			+ "/wkt/{wkt}/trs/{trs}/srs/{srs}")
	public List<TrackDataResult> queryTrackByIdAndTS(@PathVariable(value = "id") String id, 
			@PathVariable(value = "begintime") String begintime,
			@PathVariable(value = "endtime") String endtime,
			@PathVariable(value = "wkt") String wkt,
			@PathVariable(value = "trs") String trs,
			@PathVariable(value = "srs") String srs) {
		List<TrackDataResult> result = trackDao.queryTrackByIdAndTS(id,
				Long.valueOf(begintime).longValue(), 
				Long.valueOf(endtime).longValue(), wkt, 1, 1);
		return result;
	}


}
