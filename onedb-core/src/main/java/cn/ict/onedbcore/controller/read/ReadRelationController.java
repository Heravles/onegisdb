package cn.ict.onedbcore.controller.read;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.RelationResultDao;
import cn.ict.onedbcore.model.RelationResult;

@RestController
@RequestMapping("/api/read")
public class ReadRelationController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private RelationResultDao relationResultDao;
	
	@RequestMapping(value = "/relation/id/{id}/dep/{dep}")
	public List<RelationResult> queryById(@PathVariable(value = "id") String id,
			@PathVariable(value = "dep") int dep) {
		List<RelationResult> result = relationResultDao.queryByIdAndDep(
				Long.valueOf(id).longValue(), dep);
		return result;
	}

	@RequestMapping(value = "/relation/id/{id}/relation/{relation}/dep/{dep}")
	public List<RelationResult> queryById(@PathVariable(value = "id") String id,
			@PathVariable(value = "relation") int relation,
			@PathVariable(value = "dep") int dep) {
		List<RelationResult> result = relationResultDao.queryByIdAndRelationAndDep(
				Long.valueOf(id).longValue(), relation, dep);
		return result;
	}

}
