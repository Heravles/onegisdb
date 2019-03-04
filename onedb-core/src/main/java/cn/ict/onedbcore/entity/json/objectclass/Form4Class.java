package cn.ict.onedbcore.entity.json.objectclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Form4Class {
	private Long id;
	private String name;
	private String type;
	private String geotype;
	private Integer dim;
	@JsonProperty(value = "minGrain")
	private Double mingrain;
	@JsonProperty(value = "maxGrain")
	private Double maxgrain;
}
