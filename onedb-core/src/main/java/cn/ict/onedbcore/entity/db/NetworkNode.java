package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.google.gson.Gson;
import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.object.Edge4Json;
import cn.ict.onedbcore.entity.json.object.Node4Json;
import cn.ict.onedbcore.entity.json.object.RefObject;
import cn.ict.onedbcore.entity.json.objectclass.ConnectorElement;
import lombok.Data;

@Data
@Entity
@Table(name = "networknode")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class NetworkNode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Long object_id;
	private Long trs;
	private Long time;
	@NotNull
	private Long refobject_id;
	private String refobject_name;
	private Long refotype_id;
	private String refotype_name;
	@Type(type = "long-array")
	@Column(
		name = "properties",
		columnDefinition = "bigint[]"
	)
	private String properties;
	private String edge_label;
	private Long edgerelation_id;
	private String edgerelation_name;
	private Integer intensity;
	//private long[] rules;
	//private long[] attributes;

	public void NodeFromWrapper(Node4Json node4Json, Long object_id, Long trsid, Long vtime) {
		this.object_id = object_id;
		if (null != trsid) {
			this.trs = trsid;
		}
		this.time = vtime;
		RefObject refObject = node4Json.getRefobject();
		if (null != refObject) {
			this.refobject_id = refObject.getId();
			this.refobject_name = refObject.getName();
			if (null != refObject.getOtype()) {
				this.refotype_id = refObject.getOtype().getId();
				this.refotype_name = refObject.getOtype().getName();
			}
		}
		Gson gson = new Gson();
		if (null != node4Json.getProperties() && node4Json.getProperties().size() != 0) {
			this.properties = node4Json.getProperties().toString();//gson.toJson(node4Json.getProperties());
		}
		Edge4Json edge4Json = node4Json.getEdge();
		if (null != edge4Json) {
			this.edge_label = edge4Json.getLabel();
			ConnectorElement relation = edge4Json.getRelation();
			if (null != relation) {
				this.edgerelation_id = relation.getId();
				this.edgerelation_name = relation.getName();
			}
			this.intensity = edge4Json.getIntensity();
		}
	}
}
