package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cn.ict.onedbcore.entity.json.object.Attribute4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "objectattribute")
public class Attribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Long object_id;
	private String name;
	private String value;
	private Long trs;
	@NotNull
	private Long time;
	private Long id;
	
	public void AttributeFromWrapper(Attribute4Json attribute4Json, Long object_id, Long trsid, Long vtime) {
		this.object_id = object_id;
		this.id = attribute4Json.getId();
		this.name = attribute4Json.getName();
		this.value = attribute4Json.getValue();
		if (trsid != 0)
			this.trs = trsid;
		this.time = vtime;
	}
	
}
