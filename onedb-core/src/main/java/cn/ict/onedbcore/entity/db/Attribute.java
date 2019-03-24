package cn.ict.onedbcore.entity.db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.object.Attribute4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "objectattribute")
public class Attribute {
	@EmbeddedId
	private EmbededIdTime identity;
	private Long object_id;
	private String name;
	private String value;
	private Long trs;
	
	public void AttributeFromWrapper(Attribute4Json attribute4Json, Long object_id, Long trsid, Long vtime) {
		this.object_id = object_id;
		this.identity = new EmbededIdTime();
		this.identity.setId(attribute4Json.getId());
		this.identity.setTime(vtime);
		this.name = attribute4Json.getName();
		this.value = attribute4Json.getValue();
		if (trsid != 0)
			this.trs = trsid;
	}
	
}
