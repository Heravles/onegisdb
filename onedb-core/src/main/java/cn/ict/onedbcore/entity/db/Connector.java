package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.objectclass.Connector4Json;
import cn.ict.onedbcore.enums.RelationTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "objectclassconnector")
public class Connector {
	@Id
	private Long id;
	private String name;
	private Integer type;
	private Long relation_id;
	private String relation_name;
	private Long targetclass_id;
	private String targetclass_name;

	public void GetConnectorFromWrapper(Connector4Json connector4Json) {
		this.id = connector4Json.getId();
		this.name = connector4Json.getName();
		if (null != connector4Json.getType()) {
			this.type = GetType(connector4Json.getType());
		}
		if (null != connector4Json.getRelation()) {
			this.relation_id = connector4Json.getRelation().getId();
			this.relation_name = connector4Json.getRelation().getName();
		}
		if (null != connector4Json.getTarget()) {
			this.targetclass_id = connector4Json.getTarget().getId();
			this.targetclass_name = connector4Json.getTarget().getName();
		}
	}

	public Integer GetType(String relationType) {
		switch (relationType) {
		case "realization":
			return RelationTypeEnum.REALIZATION.getValue();
		case "aggregation":
			return RelationTypeEnum.AGGREGATION.getValue();
		case "composition":
			return RelationTypeEnum.COMPOSITION.getValue();
		case "dependency":
			return RelationTypeEnum.DEPENDENCY.getValue();
		case "association":
			return RelationTypeEnum.ASSOCIATION.getValue();
		default:
			return 0;
		}
	}
}
