package cn.ict.onedbcore.entity.json.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ict.onedbcore.entity.json.objectclass.ConnectorElement;
import cn.ict.onedbcore.model.obj.NetworkResult;
import lombok.Data;

@Data
public class Node4Json {
	@JsonProperty(value = "refObject")
	private RefObject refobject;
	private List<NodeProperty> properties;
	private Edge4Json edge;
	
	public void Node4JsonFromResult(NetworkResult networkResult) {
		this.refobject = new RefObject();
		this.refobject.setId(networkResult.getRefobject_id());
		this.refobject.setName(networkResult.getRefobject_name());
		Otype otype = new Otype();
		otype.setId(networkResult.getRefotype_id());
		otype.setName(networkResult.getRefotype_name());
		this.refobject.setOtype(otype);
		this.edge = new Edge4Json();
		this.edge.setLabel(networkResult.getEdge_label());
		ConnectorElement relation = new ConnectorElement();
		relation.setId(networkResult.getEdgerelation_id());
		relation.setName(networkResult.getEdgerelation_name());
		this.edge.setRelation(relation);
		this.edge.setIntensity(networkResult.getIntensity());
	}
	

}
