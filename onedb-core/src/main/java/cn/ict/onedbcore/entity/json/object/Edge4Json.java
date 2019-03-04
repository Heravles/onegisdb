package cn.ict.onedbcore.entity.json.object;

import java.util.List;

import cn.ict.onedbcore.entity.json.objectclass.ConnectorElement;
import lombok.Data;

@Data
public class Edge4Json {
	private String label;
	private List<Attribute4Json> attributes;
	private ConnectorElement relation;
	private Integer intensity;
	//private List<Rule> rules;

}
