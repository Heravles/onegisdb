package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.object.Action4Json;
import cn.ict.onedbcore.enums.ActionTypeEnum;
import cn.ict.onedbcore.enums.ObjectTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "operation")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Long operation_id;
	private Integer actionoperation;
	private Integer objectoperation;

	public ObjectTypeEnum ActionFromWrapper(Action4Json action4Json) {
		this.operation_id = action4Json.getId();
		this.actionoperation = getActionType(action4Json.getOperation().getActionoperationtype());
		ObjectTypeEnum objectType = getObjectType(action4Json.getOperation().getObjectoperationtype());
		//System.out.println(action4Json.getOperation().getObjectoperationtype());
		this.objectoperation = objectType.getValue();
		return objectType;
	}
	
	public Integer getActionType(String type) {
		switch(type) {
		case "ADDING":
			return ActionTypeEnum.ADD.getValue();
		case "DELETE":
			return ActionTypeEnum.DELETE.getValue();
		case "MODIFY":
			return ActionTypeEnum.MODIFY.getValue();
		default:
			return 0;
		}
	}
	
	public ObjectTypeEnum getObjectType(String type) {
		switch(type) {
		case "BASE":
			return ObjectTypeEnum.BASE;
		case "ATTRIBUTE":
			return ObjectTypeEnum.ATTRIBUTE;
		case "FORM":
			return ObjectTypeEnum.FORM;
		case "RELATION":
			return ObjectTypeEnum.RELATION;
		case "COMPOSE":
			return ObjectTypeEnum.COMPOSE;
		case "MODEL":
			return ObjectTypeEnum.MODEL;
		case "REFERENCE":
			return ObjectTypeEnum.REFERENCE;
		default:
			return null;
		}
	}
}
