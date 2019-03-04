package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.ObjectClass4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "objectclass")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class ObjectClass {
	@Id
	private Long id;
	private String name;
	private String description;
	private Long srs;
	private Long trs;
	@Type(type = "long-array")
	@Column(
		name = "fields",
		columnDefinition = "bigint[]"
	)
	private long[] fields;
	@Type(type = "long-array")
	@Column(
		name = "forms",
		columnDefinition = "bigint[]"
	)
	private long[] forms;
	@Type(type = "long-array")
	@Column(
		name = "connectors",
		columnDefinition = "bigint[]"
	)
	private long[] connectors;
	//private long[] models;
	
	public void ObjectClassFromWrapper(ObjectClass4Json objectClass4Json, Long trsid, Long srsid) {
		this.id = objectClass4Json.getId();
		this.name = objectClass4Json.getName();
		this.description = objectClass4Json.getDescription();
		this.srs = srsid;
		this.trs = trsid;
		this.fields = objectClass4Json.getIdList4Fields();
		this.forms = objectClass4Json.getIdList4Forms();
		this.connectors = objectClass4Json.getIdList4Connectors();
	}
}
