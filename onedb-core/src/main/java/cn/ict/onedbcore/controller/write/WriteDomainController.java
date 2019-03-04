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



@RestController
@RequestMapping("/api/write")
public class WriteDomainController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DomainDao domainDao;
	@Autowired
	SRSTRSDao srsTrsDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/domain")
	public List<Domain> writeDomain(@RequestBody List<Domain4Json> domain4Jsons) {
		List<Domain> domains = new ArrayList<>();
		for (Domain4Json domain4Json : domain4Jsons) {
			Domain domain = new Domain();
			domain.DomainFromWrapper(domain4Json, srsTrsDao.getTrsIdByCode(domain4Json.getTrs()),
					srsTrsDao.getSrsIdByCode(domain4Json.getSrs()));
			domains.add(domain);
		}
		System.out.println(domains);
		domainDao.saveAll(domains);
		return domains;
	}

}
