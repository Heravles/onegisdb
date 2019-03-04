package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.object.Edge4Json;
import cn.ict.onedbcore.entity.json.objectclass.ConnectorElement;
import lombok.Data;

@Data
@Entity
@Table(name = "networksection")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class NetworkEdge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private String label;
	@Type(type = "long-array")
	@Column(
		name = "attributes",
		columnDefinition = "bigint[]"
	)
	private long[] attributes;
	private Long relation_id;
	private String relation_name;
	private Integer intensity;
	
	public void EdgeFromWrapper(Edge4Json edge4Json) {
		this.label = edge4Json.getLabel();
		ConnectorElement relation = edge4Json.getRelation();
		if (null != relation) {
			this.relation_id = relation.getId();
			this.relation_name = relation.getName();
		}
		this.intensity = edge4Json.getIntensity();
	}
}
