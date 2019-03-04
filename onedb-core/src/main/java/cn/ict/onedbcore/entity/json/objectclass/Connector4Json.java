package cn.ict.onedbcore.entity.json.objectclass;

import lombok.Data;

@Data
public class Connector4Json {
	private Long id;
	private String name;
	private String type;
	private ConnectorElement relation;
	private ConnectorElement target;
}
