package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteRelationController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	RelationDao relationDao;

	@Autowired
	FieldDao fieldDao;
	

	@RequestMapping(method = RequestMethod.POST, value = "/relation")
	public ResultResponse<Long> writeDobjects(@RequestBody List<Relation4Json> relation4Jsons) {
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
		List<Relation> resultLists = new ArrayList<Relation>();
		ResultResponse<Long> result = new ResultResponse<Long>("relation");
		try {
			fieldDao.saveAll(fieldList);
			resultLists = relationDao.saveAll(relations);
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
