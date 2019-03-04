package cn.ict.onedbcore.controller.read;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.FeaturesDao;

@RestController
@RequestMapping("/api/features")
public class FeaturesController {

	@Autowired
	private FeaturesDao featuresDao;

	@RequestMapping("/baseinfo")
	public List<Map<String, Object>> getObjBaseInfo(){
		return featuresDao.getObjBaseInfo();
	}

	@RequestMapping("/subobjid/id/{id}")
	public List<Long> getSubObjId(@PathVariable(value = "id") int id){
		return featuresDao.getSubObjId(id);
	}
	
	@RequestMapping("/parobjid/id/{id}")
	public Long getParentObjId(@PathVariable(value = "id") int id) {
		return featuresDao.getParentId(id);
	}
	
	@RequestMapping("/objid/pageNum/{pageNum}/pageSize/{pageSize}")
	public List<Long> getObjIdByPage(@PathVariable(value = "pageNum") int pageNum,
									@PathVariable(value = "pageSize") int pageSize){
		return featuresDao.getObjIdByPage(pageNum, pageSize, 1, true);
	}
	
	
	@RequestMapping("/objid/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}")
	public List<Long> getObjIdByPage(@PathVariable(value = "pageNum") int pageNum,
									@PathVariable(value = "pageSize") int pageSize,
									@PathVariable(value = "orderType") int orderType,
									@PathVariable(value = "descOrAsc") boolean descOrAsc){
		return featuresDao.getObjIdByPage(pageNum, pageSize, orderType, descOrAsc);
	}
	
	@RequestMapping("/objid/pageNum/{pageNum}/pageSize/{pageSize}/timefilter/{time}")
	public List<Long> getObjIdByPage(@PathVariable(value = "pageNum") int pageNum,
									@PathVariable(value = "pageSize") int pageSize,
									@PathVariable(value = "time") String time){
		Timestamp timefilter = Timestamp.valueOf(time);
		return featuresDao.getObjIdByPageAndTime(pageNum, pageSize, 1, true, timefilter);
	}
	
	@RequestMapping("/objid/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}/timefilter/{time}")
	public List<Long> getObjIdByPage(@PathVariable(value = "pageNum") int pageNum,
									@PathVariable(value = "pageSize") int pageSize,
									@PathVariable(value = "orderType") int orderType,
									@PathVariable(value = "descOrAsc") boolean descOrAsc,
									@PathVariable(value = "time") String time){
		Timestamp timefilter = Timestamp.valueOf(time);
		return featuresDao.getObjIdByPageAndTime(pageNum, pageSize, orderType, descOrAsc, timefilter);
	}
}
