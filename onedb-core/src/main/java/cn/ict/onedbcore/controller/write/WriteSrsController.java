package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.SrsDao;
import cn.ict.onedbcore.entity.db.Srs;
import cn.ict.onedbcore.entity.json.SrsTrs;
import cn.ict.onedbcore.entity.json.srstrs.Derived;
import cn.ict.onedbcore.entity.json.srstrs.SystemCell;
import cn.ict.onedbcore.enums.SrsTrsEnum;
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteSrsController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	SrsDao srsDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/srs")
	public ResultResponse<String> writeSrs(@RequestBody List<SrsTrs> srsList) {
		System.out.println(srsList);
		List<Srs> srses = new ArrayList<>();
		for (SrsTrs srstrs : srsList) {
			if (!srstrs.getSystem().isEmpty()) {
				for (SystemCell systemCell : srstrs.getSystem()) {
					Srs srs = new Srs();
					srs.setCode(systemCell.getId());
					srs.setType(SrsTrsEnum.SYSTEM.getCode());
					srs.setWkt(systemCell.getWkt());
					srses.add(srs);
				}
			}
			if (!srstrs.getSystem().isEmpty()) {
				for (Derived derived : srstrs.getDerived()) {
					Srs srs = new Srs();
					srs.setCode(derived.getId());
					srs.setType(SrsTrsEnum.DERIVED.getCode());
					srs.setWkt(derived.getWkt());
					srses.add(srs);
				}
			}
		}
		List<Srs> resultLists = new ArrayList<Srs>();
		ResultResponse<String> result = new ResultResponse<String>("srs");
		try {
			resultLists = srsDao.saveAll(srses);
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
				result.setSamplekey(resultLists.get(0).getCode());
			}
		}
		return result;
	}
}
