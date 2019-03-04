package cn.ict.onedbcore.entity.json.object;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FormRef {
	private String name;
	@JsonProperty(value = "desc")
	private String description;
	private String fname;
	private String extension;

}
