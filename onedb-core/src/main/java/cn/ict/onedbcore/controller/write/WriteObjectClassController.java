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

import cn.ict.onedbcore.dao.ConnectorDao;
import cn.ict.onedbcore.dao.DobjectDao;
import cn.ict.onedbcore.dao.FieldDao;
import cn.ict.onedbcore.dao.ObjectClassDao;
import cn.ict.onedbcore.dao.ObjectClassFormDao;
import cn.ict.onedbcore.dao.SRSTRSDao;
import cn.ict.onedbcore.entity.db.Connector;
import cn.ict.onedbcore.entity.db.Field;
import cn.ict.onedbcore.entity.db.ObjectClass;
import cn.ict.onedbcore.entity.db.ObjectClassForm;
import cn.ict.onedbcore.entity.json.ObjectClass4Json;
import cn.ict.onedbcore.entity.json.common.Field4Json;
import cn.ict.onedbcore.entity.json.objectclass.Connector4Json;
import cn.ict.onedbcore.entity.json.objectclass.Form4Class;
import cn.ict.onedbcore.error.ResultResponse;



@RestController
@RequestMapping("/api/write")
public class WriteObjectClassController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DobjectDao dobjectDao;
	@Autowired
	SRSTRSDao srsTrsDao;
	@Autowired
	FieldDao fieldDao;
	@Autowired
	ObjectClassFormDao objectClassFormDao;
	@Autowired
	ConnectorDao connectorDao;
	@Autowired
	ObjectClassDao objectClassDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/class")
	public ResultResponse<Long> writeDobjects(@RequestBody List<ObjectClass4Json> objectClass4Jsons) {
		List<ObjectClass> objectClasses = new ArrayList<>();
		Set<Field4Json> fieldSet = new HashSet<>();
		Set<Form4Class> form4ClassSet = new HashSet<>();
		Set<Connector4Json> connector4JsonSet = new HashSet<>();
		for (ObjectClass4Json objectClass4Json : objectClass4Jsons) {
			ObjectClass objectClass = new ObjectClass();
			objectClass.ObjectClassFromWrapper(objectClass4Json, 
					srsTrsDao.getTrsIdByCode(objectClass4Json.getTrs()), 
					srsTrsDao.getSrsIdByCode(objectClass4Json.getSrs()));
			objectClasses.add(objectClass);
			fieldSet.addAll(objectClass4Json.getFields());
			form4ClassSet.addAll(objectClass4Json.getForms());
			connector4JsonSet.addAll(objectClass4Json.getConnectors());
		}
		List<ObjectClass> resultLists = new ArrayList<ObjectClass>();
		ResultResponse<Long> result = new ResultResponse<Long>("objectclass");
		try {
			saveFields(fieldSet);
			saveForms(form4ClassSet);
			saveConnectors(connector4JsonSet);
			resultLists = objectClassDao.saveAll(objectClasses);
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
	
	public void saveFields(Set<Field4Json> fieldSet) {
		List<Field> fieldList = new ArrayList<>();
		for (Field4Json field4Json : fieldSet) {
			Field field = new Field();
			field.GetFieldFromWrapper(field4Json);
			fieldList.add(field);
		}
		//System.out.println("save fields " + fieldList.size());
		fieldDao.saveAll(fieldList);
	}

	public void saveForms(Set<Form4Class> form4ClassSet) {
		List<ObjectClassForm> formList = new ArrayList<>();
		for (Form4Class form4Class : form4ClassSet) {
			ObjectClassForm objectClassForm = new ObjectClassForm(); 
			objectClassForm.FormFromClassWrapper(form4Class);
			formList.add(objectClassForm);
			System.out.println(objectClassForm);
		}
		//System.out.println("save forms " + formList.size());
		objectClassFormDao.saveAll(formList);
	}
	
	public void saveConnectors(Set<Connector4Json> connector4JsonSet) {
		List<Connector> connectorList = new ArrayList<>();
		for (Connector4Json connector4Json : connector4JsonSet) {
			Connector connector = new Connector();
			connector.GetConnectorFromWrapper(connector4Json);
			connectorList.add(connector);
		}
		//System.out.println("save connectors " + connectorList.size());
		connectorDao.saveAll(connectorList);
	}
	
}
