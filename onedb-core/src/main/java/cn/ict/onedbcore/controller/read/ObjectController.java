package cn.ict.onedbcore.controller.read;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.ObjectResultDao;
import cn.ict.onedbcore.model.ObjectResult;

@RestController
@RequestMapping("/api/object")
public class ObjectController {

	@Autowired
	private ObjectResultDao objectResultDao;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ObjectResult getById(@PathVariable(value = "id") int id) {
		return objectResultDao.getById(id);
	}
	


	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum") Integer pageNum,
											@PathVariable(value = "pageSize") Integer pageSize){
		return objectResultDao.getAllByPage(pageNum, pageSize, 1, true);
	}
	
	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum") Integer pageNum,
											@PathVariable(value = "pageSize" ) Integer pageSize,
											@PathVariable(value = "orderType" ) Integer orderType,
											@PathVariable(value = "descOrAsc" ) Boolean descOrAsc){
		return objectResultDao.getAllByPage(pageNum, pageSize, orderType, descOrAsc);
	}
	
	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}/timefilter/{time}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum" ) Integer pageNum,
											@PathVariable(value = "pageSize" ) Integer pageSize,
											@PathVariable(value = "time" ) String time){
		Timestamp timefilter = Timestamp.valueOf(time);
		return objectResultDao.getAllByPageAndTime(pageNum, pageSize, 1, true, timefilter);
	}
	
	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}/timefilter/{time}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum" ) Integer pageNum,
											@PathVariable(value = "pageSize" ) Integer pageSize,
											@PathVariable(value = "orderType" ) Integer orderType,
											@PathVariable(value = "descOrAsc" ) Boolean descOrAsc,
											@PathVariable(value = "time" ) String time){
		Timestamp timefilter = Timestamp.valueOf(time);
		return objectResultDao.getAllByPageAndTime(pageNum, pageSize, orderType, descOrAsc, timefilter);
	}
	
	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}/timefilter/{time}"
			+ "/condName/{condName}/condType/{condType}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum" ) Integer pageNum,
											@PathVariable(value = "pageSize" ) Integer pageSize,
											@PathVariable(value = "orderType" ) Integer orderType,
											@PathVariable(value = "descOrAsc" ) Boolean descOrAsc,
											@PathVariable(value = "time" ) String time,
											@PathVariable(value = "condName") String condName,
											@PathVariable(value = "condType") String condType){
		Timestamp timefilter = Timestamp.valueOf(time);
		if ("null".equals(condName))
			condName = null;
		if ("null".equals(condType))
			condType = null;
		return objectResultDao.getAllByTimeAndCondAndPage(pageNum, pageSize, orderType, descOrAsc, timefilter, condName, condType);
	}
	
	@RequestMapping(value = "/pageNum/{pageNum}/pageSize/{pageSize}/orderType/{orderType}/descOrAsc/{descOrAsc}"
			+ "/condName/{condName}/condType/{condType}", method = RequestMethod.GET)
	public List<ObjectResult> getAllByPage(@PathVariable(value = "pageNum" ) Integer pageNum,
											@PathVariable(value = "pageSize" ) Integer pageSize,
											@PathVariable(value = "orderType" ) Integer orderType,
											@PathVariable(value = "descOrAsc" ) Boolean descOrAsc,
											@PathVariable(value = "condName" ) String condName,
											@PathVariable(value = "condType" ) String condType){
		if ("null".equals(condName))
			condName = null;
		if ("null".equals(condType))
			condType = null;
		return objectResultDao.getAllByTimeAndCondAndPage(pageNum, pageSize, orderType, descOrAsc, null, condName, condType);
	}

}
