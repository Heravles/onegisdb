package cn.ict.onedbcore.entity.json.object;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ict.onedbcore.enums.ActionTypeEnum;
import cn.ict.onedbcore.enums.ObjectTypeEnum;
import cn.ict.onedbcore.model.obj.ActionResult;
import cn.ict.onedbcore.model.obj.AttributeResult;
import cn.ict.onedbcore.model.obj.NetworkResult;
import cn.ict.onedbcore.model.obj.ObjectFormResult;
import lombok.Data;

@Data
public class Version4Json {
	private Long vtime;
	private List<Action4Json> actions;
	private List<VersionBase> base;
	private List<Attribute4Json> attributes;
	private List<Form4Object> forms;
	@JsonProperty(value = "networks")
	private List<NetWork4Json> relation;
	private List<Long> compose;
	//private List<Model> model;
	private List<Reference> reference;
	
	public List<Action4Json> ConvertActionFromResult(List<ActionResult> actionResults) {
		this.actions = new ArrayList<>();
		for (ActionResult actionResult : actionResults) {
			Action4Json action4Json = new Action4Json();
			action4Json.setId(actionResult.getOperation_id());
			Operation operation = new Operation();
			operation.setActionoperationtype(getActionType(actionResult.getActionoperation()));
			operation.setObjectoperationtype(getObjectType(actionResult.getObjectoperation()));
			action4Json.setOperation(operation);
			this.actions.add(action4Json);
		}
		return this.actions;
	}

	public void ConvertAttrResult(List<AttributeResult> attributeResults, Long vtime) {
		this.attributes = new ArrayList<>();
		for (AttributeResult attributeResult : attributeResults) {
			if (!attributeResult.getTime().equals(vtime))
				continue;
			Attribute4Json attribute4Json = new Attribute4Json();
			attribute4Json.setId(attributeResult.getId());
			attribute4Json.setName(attributeResult.getName());
			attribute4Json.setValue(attributeResult.getValue());
			this.attributes.add(attribute4Json);
		}
	}
	
	public void ConverFormResult(List<ObjectFormResult> objectFormResults, Long vtime) {
		this.forms = new ArrayList<>();
		for (ObjectFormResult objectFormResult : objectFormResults) {
			if (!objectFormResult.getTime().equals(vtime))
				continue;
			Form4Object form4Object = new Form4Object();
			form4Object.Form4ObjectFromResult(objectFormResult);
			this.forms.add(form4Object);
		}
	}
	
	public void ConvertNetworkResult(List<NetworkResult> networkResults, Long vtime) {
		this.relation = new ArrayList<>();
		NetWork4Json netWork4Json = new NetWork4Json();
		for (NetworkResult networkResult : networkResults) {
			if (!networkResult.getTime().equals(vtime))
				continue;
			Node4Json node4Json = new Node4Json();
			node4Json.Node4JsonFromResult(networkResult);
			netWork4Json.addNode(node4Json);
		}
		this.relation.add(netWork4Json);
	}
	
	public String getActionType(Integer code) {
		switch(code) {
		case 1:
			return ActionTypeEnum.ADD.getType();
		case 2:
			return ActionTypeEnum.DELETE.getType();
		case 4:
			return ActionTypeEnum.MODIFY.getType();
		default:
			return "error";
		}
	}

	
	public String getObjectType(Integer code) {
		switch(code) {
		case 32:
			return ObjectTypeEnum.BASE.getType();
		case 64:
			return ObjectTypeEnum.ATTRIBUTE.getType();
		case 128:
			return ObjectTypeEnum.FORM.getType();
		case 256:
			return ObjectTypeEnum.RELATION.getType();
		case 512:
			return ObjectTypeEnum.COMPOSE.getType();
		case 1024:
			return ObjectTypeEnum.MODEL.getType();
		case 2048:
			return ObjectTypeEnum.REFERENCE.getType();
		default:
			return "error";
		}
	}
}
