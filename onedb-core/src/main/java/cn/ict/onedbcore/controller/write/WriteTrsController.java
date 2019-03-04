package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.TrsDao;
import cn.ict.onedbcore.entity.db.Trs;
import cn.ict.onedbcore.entity.json.SrsTrs;
import cn.ict.onedbcore.entity.json.srstrs.Derived;
import cn.ict.onedbcore.entity.json.srstrs.SystemCell;
import cn.ict.onedbcore.enums.SrsTrsEnum;



@RestController
@RequestMapping("/api/write")
public class WriteTrsController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	TrsDao trsDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/trs")
	public List<SrsTrs> writeTrs(@RequestBody List<SrsTrs> trsList) {
		System.out.println(trsList);
		List<Trs> trses = new ArrayList<>();
		for (SrsTrs srstrs : trsList) {
			if (!srstrs.getSystem().isEmpty()) {
				for (SystemCell systemCell : srstrs.getSystem()) {
					Trs Trs = new Trs();
					Trs.setCode(systemCell.getId());
					Trs.setType(SrsTrsEnum.SYSTEM.getCode());
					Trs.setWkt(systemCell.getWkt());
					trses.add(Trs);
				}
			}
			if (!srstrs.getSystem().isEmpty()) {
				for (Derived derived : srstrs.getDerived()) {
					Trs Trs = new Trs();
					Trs.setCode(derived.getId());
					Trs.setType(SrsTrsEnum.DERIVED.getCode());
					Trs.setWkt(derived.getWkt());
					trses.add(Trs);
				}
			}
		}
		trsDao.saveAll(trses);
		return trsList;
	}
}
