package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.google.gson.Gson;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import cn.ict.onedbcore.entity.json.common.Field4Json;
import cn.ict.onedbcore.enums.ValueTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "objectclassfield")
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonStringType.class),
})
public class Field {
	@Id
	private Long id;
	private String name;
	private String caption;
	private String description;
	private Integer type;
	private String domain;
	private String defaultValue;
	
	public Field() {
		this.defaultValue = null;
	}
	public void GetFieldFromWrapper(Field4Json field4Json) {
		this.id = field4Json.getId();
		this.name = field4Json.getName();
		this.caption = field4Json.getCaption();
		this.description = field4Json.getDescription();
		if (null != field4Json.getType()) {
			this.type = GetType(field4Json.getType());
		}
		Gson gson = new Gson();
		if (null != field4Json.getDomain()) {
			this.domain = gson.toJson(field4Json.getDomain());
		}
		this.defaultValue = field4Json.getDefaulstValue();
	}
	
	public Integer GetType(String ValueType) {
		switch (ValueType) {
		case "short":
			return ValueTypeEnum.SHORT.getCode();
		case "int":
			return ValueTypeEnum.INT.getCode();
		case "long":
			return ValueTypeEnum.LONG.getCode();
		case "float":
			return ValueTypeEnum.FLOAT.getCode();
		case "double":
			return ValueTypeEnum.DOUBLE.getCode();
		case "text":
			return ValueTypeEnum.TEXT.getCode();
		case "datetime":
			return ValueTypeEnum.DATETIME.getCode();
		case "boolean":
			return ValueTypeEnum.BOOLEAN.getCode();
		default:
			return 0;
		}
		
	}
}
