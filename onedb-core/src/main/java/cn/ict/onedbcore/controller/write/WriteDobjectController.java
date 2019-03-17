package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.DobjectDao;
import cn.ict.onedbcore.entity.Dobject;
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteDobjectController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DobjectDao dobjectDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/dobject")
	public ResultResponse<Long> writeDobjects(@RequestBody List<Dobject> dobjects) {
		List<Dobject> resultLists = new ArrayList<Dobject>();
		ResultResponse<Long> result = new ResultResponse<Long>("dobject");
		try {
			resultLists = dobjectDao.saveAll(dobjects);
		} catch (Exception e) {
			result.setSuccess(false);
			Throwable cause = e.getCause();
		    if(cause instanceof org.hibernate.exception.ConstraintViolationException) {
		        String errMsg = 
		        		((org.hibernate.exception.ConstraintViolationException)cause).
		        		getSQLException().getMessage();
		        result.setMessage(errMsg);
		    } else {
		    	result.setMessage(e.getMessage());
		    }
		} finally {
			result.setCount(resultLists.size());
			if (result.getCount() > 0) {
				result.setSamplekey(resultLists.get(0).getId());
			}
		}
		return result;
	}
}
