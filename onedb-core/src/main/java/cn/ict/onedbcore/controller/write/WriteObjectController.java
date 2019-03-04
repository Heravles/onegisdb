package cn.ict.onedbcore.controller.write;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ict.onedbcore.dao.ActionDao;
import cn.ict.onedbcore.dao.AttributeDao;
import cn.ict.onedbcore.dao.DobjectDao;
import cn.ict.onedbcore.dao.NetworkNodeDao;
import cn.ict.onedbcore.dao.ObjectDao;
import cn.ict.onedbcore.dao.ObjectFormDao;
import cn.ict.onedbcore.dao.PositionDao;
import cn.ict.onedbcore.dao.SRSTRSDao;
import cn.ict.onedbcore.dao.VersionDao;
import cn.ict.onedbcore.entity.db.Action;
import cn.ict.onedbcore.entity.db.Attribute;
import cn.ict.onedbcore.entity.db.NetworkNode;
import cn.ict.onedbcore.entity.db.Object;
import cn.ict.onedbcore.entity.db.ObjectForm;
import cn.ict.onedbcore.entity.db.Position;
import cn.ict.onedbcore.entity.db.Version;
import cn.ict.onedbcore.entity.json.Object4Json;
import cn.ict.onedbcore.entity.json.object.Action4Json;
import cn.ict.onedbcore.entity.json.object.Attribute4Json;
import cn.ict.onedbcore.entity.json.object.Form4Object;
import cn.ict.onedbcore.entity.json.object.NetWork4Json;
import cn.ict.onedbcore.entity.json.object.Node4Json;
import cn.ict.onedbcore.entity.json.object.Version4Json;
import cn.ict.onedbcore.enums.ObjectTypeEnum;



@RestController
@RequestMapping("/api/write")
public class WriteObjectController {
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	DobjectDao dobjectDao;
	@Autowired
	SRSTRSDao srsTrsDao;
	@Autowired
	ActionDao actionDao;
	@Autowired
	ObjectDao objectDao;
	@Autowired
	ObjectFormDao objectFormDao;
	@Autowired
	AttributeDao attributeDao;
	@Autowired
	PositionDao positionDao;
	@Autowired
	VersionDao versionDao;
	@Autowired
	NetworkNodeDao networkNodeDao;
	
	@RequestMapping(method = RequestMethod.POST, value = "/object")
	public List<Object4Json> writeDobjects(@RequestBody List<Object4Json> object4Jsons) {
		List<Attribute> attributeList = new ArrayList<>();
		List<ObjectForm> formList = new ArrayList<>();
		List<NetworkNode> nodeList = new ArrayList<>();
		List<Position> positionList = new ArrayList<>();
		List<Version> versionList = new ArrayList<>();
		List<Object> objectList = new ArrayList<>();
		for (Object4Json object4Json : object4Jsons) {
			Long object_id = object4Json.getId();
			Long trsid = srsTrsDao.getTrsIdByCode(object4Json.getTrs());
			Long srsid = srsTrsDao.getSrsIdByCode(object4Json.getSrs());
			Long vtime = object4Json.getRealtime();
			//Attribute
			List<Attribute> attributes = AttributeConvert(object4Json.getAttributes(), 
					object_id, trsid, vtime);
			attributeList.addAll(attributes);
			//Form
			List<ObjectForm> objectForms = FormConvert(object4Json.getForms(), object_id, trsid, vtime);
			formList.addAll(objectForms);
			//Position
			List<Position> positions = PositionConvert(object4Json.getForms(), object_id, trsid, srsid, vtime);
			positionList.addAll(positions);
			//Network
			NetWork4Json netWork4Json = object4Json.getNetwork();
			if (null != netWork4Json && null != netWork4Json.getNodes()) {
				List<NetworkNode> networkNodes = NetworkConvert(netWork4Json.getNodes(), object_id, trsid, vtime);
				nodeList.addAll(networkNodes);
			}
			Object object = new Object();
			object.ObjectFromWrapper(object4Json, trsid, srsid);
			objectList.add(object);

			List<Version4Json> version4Jsons = object4Json.getVersions();
			for (Version4Json version4Json : version4Jsons) {
				List<Action4Json> action4Jsons = version4Json.getActions();
				List<Action> actionList = new ArrayList<>();
				for (Action4Json action4Json : action4Jsons) {
					Action action = new Action();
					ObjectTypeEnum objectType = action.ActionFromWrapper(action4Json);
					actionList.add(action);
					//Write DB By Version Action
					switch (objectType) {
						case BASE:
							break;
						case ATTRIBUTE:
							attributeList.addAll(AttributeConvert(version4Json.getAttributes(), 
									object_id, trsid, version4Json.getVtime()));
							break;
						case FORM:
							formList.addAll(FormConvert(version4Json.getForms(), 
									object_id, trsid, version4Json.getVtime()));
							positionList.addAll(PositionConvert(version4Json.getForms(), 
									object_id, trsid, srsid, version4Json.getVtime()));
							break;
						case RELATION:
							List<Node4Json> node4Jsons = version4Json.getRelation().getNodes();
							if (null != node4Jsons) {
								nodeList.addAll(NetworkConvert(node4Jsons, object_id, 
										trsid, version4Json.getVtime()));
							}
							break;
						case COMPOSE:
							break;
						case MODEL:
							break;
						case REFERENCE:
							break;
						default:
							break;
					}
				}
				//Version && Action
				Version version = new Version();
				System.out.println("save action " + actionList.size());
				version.VersionFromWrapper(version4Json, object_id, trsid, //new long[1]);
						actionDao.saveAll(actionList));
				versionList.add(version);
			}
		}

		//for (NetworkNode networkNode : nodeList) {
		//	System.out.println(networkNode);
		//}
		System.out.println("save object " + objectList.size());
		objectDao.saveAll(objectList);
		System.out.println("save networkNode " + nodeList.size());
		networkNodeDao.saveAll(nodeList);
		System.out.println("save attribute " + attributeList.size());
		attributeDao.saveAll(attributeList);
		System.out.println("save form " + formList.size());
		objectFormDao.saveAll(formList);
		System.out.println("save position " + positionList.size());
		positionDao.saveAll(positionList);
		System.out.println("save version " + versionList.size());
		versionDao.saveAll(versionList);
		return object4Jsons;
	}
	
	public List<Attribute> AttributeConvert(List<Attribute4Json> attribute4Jsons,
			Long object_id, Long trsid, Long vtime){
		List<Attribute> attributes = new ArrayList<>();
		for (Attribute4Json attribute4Json : attribute4Jsons) {
			Attribute attribute = new Attribute();
			attribute.AttributeFromWrapper(attribute4Json, object_id, trsid, vtime);
			attributes.add(attribute);
		}
		return attributes;
	}
	
	public List<ObjectForm> FormConvert(List<Form4Object> form4Objects, 
			Long object_id, Long trsid, Long vtime) {
		List<ObjectForm> formList = new ArrayList<>();
		for (Form4Object form4Object : form4Objects) {
			ObjectForm objectForm = new ObjectForm();
			objectForm.FormObjectFromWrapper(form4Object, object_id, trsid, 
					vtime, form4Object.getGeom().getId());
			formList.add(objectForm);
		}
		return formList;
	}

	public List<Position> PositionConvert(List<Form4Object> form4Objects, 
			Long object_id, Long trsid, Long srsid, Long vtime) {
		List<Position> positionList = new ArrayList<>();
		for (Form4Object form4Object : form4Objects) {
			Position position = new Position();
			position.PositionFromWrapper(form4Object.getGeom(), object_id, trsid, srsid, vtime);
			if (null != position.getId())
				positionList.add(position);
		}
		return positionList;
	}
	
	public List<NetworkNode> NetworkConvert(List<Node4Json> node4Jsons, Long object_id, Long trsid, Long vtime) {
		List<NetworkNode> nodeList = new ArrayList<>();
		for (Node4Json node4Json : node4Jsons) {
			NetworkNode networkNode = new NetworkNode();
			networkNode.NodeFromWrapper(node4Json, object_id, trsid, vtime);
			nodeList.add(networkNode);
		}
		return nodeList;
	}
	
	//public List<Action> ActionConvert(List<Action4Json> action4Jsons) {
	//	List<Action> actionList = new ArrayList<>();
	//	for (Action4Json action4Json : action4Jsons) {
	//		Action action = new Action();
	//		action.ActionFromWrapper(action4Json);
	//		actionList.add(action);
	//	}
	//	return actionList;
	//}
}
