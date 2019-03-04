package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.Relation4Json;
import cn.ict.onedbcore.enums.MappingTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "relation")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class Relation {
	@Id
	private Long id;
	private String name;
	private Integer mappingtype;
	@Type(type = "long-array")
	@Column(
		name = "fields",
		columnDefinition = "bigint[]"
	)
	private long[] fields;	
	//private List<Long> rules;
	
	
	public void GetRelationFromWrapper(Relation4Json relation4Json) {
		this.id = relation4Json.getId();
		this.name = relation4Json.getName();
		if (null != relation4Json.getMappingType()) {
			this.mappingtype = GetType(relation4Json.getMappingType());
		}
		this.fields = relation4Json.getIdList4Fields();
	}
	
	public Integer GetType(String mappingType) {
		switch (mappingType) {
		case "onetoone":
			return MappingTypeEnum.OneToOne.getCode();
		case "onetomany":
			return MappingTypeEnum.OneToMany.getCode();
		case "manytoone":
			return MappingTypeEnum.ManyToOne.getCode();
		case "manytomany":
			return MappingTypeEnum.ManyToMany.getCode();
		default:
			return 0;
		}
		
	}
	
}
