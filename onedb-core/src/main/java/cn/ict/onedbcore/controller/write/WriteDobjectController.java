package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.DobjectDao;
import cn.ict.onedbcore.entity.Dobject;



@RestController
@RequestMapping("/api/write")
public class WriteDobjectController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DobjectDao dobjectDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/dobject")
	public List<Dobject> writeDobjects(@RequestBody List<Dobject> dobjects) {
		System.out.println(dobjects);
		dobjectDao.saveAll(dobjects);
		return dobjects;
	}
}
