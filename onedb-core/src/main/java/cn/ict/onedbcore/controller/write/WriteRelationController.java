package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.FieldDao;
import cn.ict.onedbcore.dao.RelationDao;
import cn.ict.onedbcore.entity.db.Field;
import cn.ict.onedbcore.entity.db.Relation;
import cn.ict.onedbcore.entity.json.Relation4Json;
import cn.ict.onedbcore.entity.json.common.Field4Json;



@RestController
@RequestMapping("/api/write")
public class WriteRelationController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	RelationDao relationDao;

	@Autowired
	FieldDao fieldDao;
	

	@RequestMapping(method = RequestMethod.POST, value = "/relation2")
	public void Demo(JSONObject jsonObject) {
		System.out.println(jsonObject);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/relation")
	public List<Relation4Json> writeDobjects(@RequestBody List<Relation4Json> relation4Jsons) {
		List<Relation> relations = new ArrayList<>();
		Set<Field4Json> fieldSet = new HashSet<>();
		for (Relation4Json relation4Json : relation4Jsons) {
			Relation relation = new Relation();
			relation.GetRelationFromWrapper(relation4Json);
			relations.add(relation);
			fieldSet.addAll(relation4Json.getFields());
		}
		List<Field> fieldList = new ArrayList<>();
		for (Field4Json field4Json : fieldSet) {
			Field field = new Field();
			field.GetFieldFromWrapper(field4Json);
			fieldList.add(field);
		}
		fieldDao.saveAll(fieldList);
		relationDao.saveAll(relations);
		return relation4Jsons;
	}
}
