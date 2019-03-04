package cn.ict.onedbcore.entity.json.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GeoJson {
	@JsonProperty(value = "geotype")
	private String type;
	private List<Object> coordinates;

}
