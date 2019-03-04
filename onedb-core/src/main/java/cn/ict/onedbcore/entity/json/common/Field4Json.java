package cn.ict.onedbcore.entity.json.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Field4Json {
	private Long id;
	private String name;
	private String caption;
	@JsonProperty(value = "desc")
	private String description;
	private String type;
	private FieldDomain domain;
	private String defaulstValue;
	

}
