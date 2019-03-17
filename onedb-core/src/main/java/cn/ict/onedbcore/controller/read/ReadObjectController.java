package cn.ict.onedbcore.controller.read;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.ActionResultDao;
import cn.ict.onedbcore.dao.ObjectResultDao;
import cn.ict.onedbcore.entity.json.Object4Json;
import cn.ict.onedbcore.entity.json.object.Version4Json;
import cn.ict.onedbcore.model.ObjectResult;
import cn.ict.onedbcore.model.obj.ActionResult;
import cn.ict.onedbcore.model.obj.VersionResult;

@RestController
@RequestMapping("/api/read")
public class ReadObjectController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ObjectResultDao objectResultDao;
	
	@Autowired
	private ActionResultDao actionResultDao;

	@RequestMapping(value = "/object/sdomain/{sdomain}")
	public List<Object4Json> queryByDomain(@PathVariable(value = "sdomain") String sdomain) {
		List<ObjectResult> result = objectResultDao.queryByDomain(Long.valueOf(sdomain).longValue());
		return getObjectJsonResult(result, "");
	}
	
	@RequestMapping(value = "/object/id/{id}")
	public List<Object4Json> queryById(@PathVariable(value = "id") String id) {
		List<ObjectResult> result = objectResultDao.queryById(Long.valueOf(id).longValue());
		return getObjectJsonResult(result, "");
	}

	@RequestMapping(value = "/object/name/{name}")
	public List<Object4Json> queryByName(@PathVariable(value = "name") String name) {
		List<ObjectResult> result = objectResultDao.queryByName(name);
		return getObjectJsonResult(result, "");
	}

	@RequestMapping(value = "/object/id/{id}/name/{name}")
	public List<Object4Json> queryByIdAndName(@PathVariable(value = "id") String id,
			@PathVariable(value = "name") String name) {
		List<ObjectResult> result = objectResultDao.queryByIdAndName(Long.valueOf(id).longValue(), 
				name);

		return getObjectJsonResult(result, "");
	}

	@RequestMapping(value = "/object/id/{id}/begintime/{begintime}/endtime/{endtime}"
			+ "/wkt/{wkt}/trs/{trs}/srs/{srs}")
	public List<Object4Json> queryByIdAndTS(@PathVariable(value = "id") String id, 
			@PathVariable(value = "begintime") String begintime,
			@PathVariable(value = "endtime") String endtime,
			@PathVariable(value = "wkt") String wkt,
			@PathVariable(value = "trs") String trs,
			@PathVariable(value = "srs") String srs) {
		List<ObjectResult> result = objectResultDao.queryByIdAndTS(id,
				Long.valueOf(begintime).longValue(), 
				Long.valueOf(endtime).longValue(), wkt, 1, 1);
		return getObjectJsonResult(result, "");
	}

	@RequestMapping(value = "/object/name/{name}/begintime/{begintime}/endtime/{endtime}"
			+ "/wkt/{wkt}/trs/{trs}/srs/{srs}")
	public List<Object4Json> queryByNameAndTS(@PathVariable(value = "name") String name, 
			@PathVariable(value = "begintime") String begintime,
			@PathVariable(value = "endtime") String endtime,
			@PathVariable(value = "wkt") String wkt,
			@PathVariable(value = "trs") String trs,
			@PathVariable(value = "srs") String srs) {
		List<ObjectResult> result = objectResultDao.queryByNameAndTS(name, 
				Long.valueOf(begintime).longValue(), 
				Long.valueOf(endtime).longValue(), wkt, 1, 1);
		return getObjectJsonResult(result, "");
	}
	
	@RequestMapping(value = "/object/id/{id}/name/{name}/begintime/{begintime}/endtime/{endtime}"
			+ "/wkt/{wkt}/trs/{trs}/srs/{srs}")
	public List<Object4Json> queryByIdAndNameAndTS(@PathVariable(value = "id") String id, 
			@PathVariable(value = "name") String name,
			@PathVariable(value = "begintime") String begintime,
			@PathVariable(value = "endtime") String endtime,
			@PathVariable(value = "wkt") String wkt,
			@PathVariable(value = "trs") String trs,
			@PathVariable(value = "srs") String srs) {
		List<ObjectResult> result = 
				objectResultDao.queryByIdAndNameAndTS(id, name,
				Long.valueOf(begintime).longValue(), 
				Long.valueOf(endtime).longValue(), wkt, 1, 1);
		return getObjectJsonResult(result, "");
	}
	
	public Map<String, Boolean> getTuples(String tuplecond) {
		Map<String, Boolean> tuples = new HashMap<>();
		if (tuplecond.equals(""))
			return tuples;
		for (String key : tuplecond.toLowerCase().split("[,，\\s]+")) {
			tuples.put(key, true);
		}
		return tuples;
	}
	
	public List<Object4Json> getObjectJsonResult(List<ObjectResult> result, String tuplecond) {
		tuplecond = "attribute,form,network,model";
		Map<String, Boolean> tuples = getTuples(tuplecond);
		List<Object4Json> object4JsonList = new ArrayList<>();
		for (ObjectResult objectResult : result) {
			Object4Json object4Json = new Object4Json();
			object4Json.Object4JsonFromResult(objectResult, tuples);
			object4Json.setVersions(ConverVersions(objectResult.getVersions_cur(), 
					objectResult, tuples));
			object4JsonList.add(object4Json);
		}
		return object4JsonList;
	}
	
	public List<Version4Json> ConverVersions (List<VersionResult> versionResults,
			ObjectResult objectResult, Map<String, Boolean> tuples) {
		List<Version4Json> version4JsonList = new ArrayList<>();
		for (VersionResult versionResult : versionResults) {
			Version4Json version4Json = new Version4Json();
			Long vtime = versionResult.getVtime();
			version4Json.setVtime(vtime);
			List<ActionResult> actionResultList = 
					actionResultDao.queryById(versionResult.GetActionsString());
			version4Json.ConvertActionFromResult(actionResultList, tuples);
			if (null == version4Json.getActions() || version4Json.getActions().size() == 0)
				continue;
			version4Json.ConvertAttrResult(objectResult.getAttributes_cur(), vtime);
			version4Json.ConverFormResult(objectResult.getForms_cur(), vtime);
			version4Json.ConvertNetworkResult(objectResult.getNetworknodes_cur(), vtime);
			version4JsonList.add(version4Json);
		}
		return version4JsonList;
		
	}

}
