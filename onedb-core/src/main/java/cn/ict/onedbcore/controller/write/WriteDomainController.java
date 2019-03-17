package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.DomainDao;
import cn.ict.onedbcore.dao.SRSTRSDao;
import cn.ict.onedbcore.entity.db.Domain;
import cn.ict.onedbcore.entity.json.Domain4Json;
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteDomainController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DomainDao domainDao;
	@Autowired
	SRSTRSDao srsTrsDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/domain")
	public ResultResponse<Long> writeDomain(@RequestBody List<Domain4Json> domain4Jsons) {
		List<Domain> domains = new ArrayList<>();
		for (Domain4Json domain4Json : domain4Jsons) {
			Domain domain = new Domain();
			domain.DomainFromWrapper(domain4Json, srsTrsDao.getTrsIdByCode(domain4Json.getTrs()),
					srsTrsDao.getSrsIdByCode(domain4Json.getSrs()));
			domains.add(domain);
		}
		List<Domain> resultLists = new ArrayList<Domain>();
		ResultResponse<Long> result = new ResultResponse<Long>("domain");
		try {
			resultLists = domainDao.saveAll(domains);
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
