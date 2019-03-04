package cn.ict.onedbcore.entity.json;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Service
@Data
public class Domain4Json {
	private Long id;
	private String name;
	@JsonProperty(value = "desc")
	private String description;
	@JsonProperty(value = "parentId")
	private Long parent_id;	
	private String trs;
	private String srs;
	@JsonProperty(value = "geoBox")
	private List<Double> geobox;
	@JsonProperty(value = "stime")
	private Long stime;
	@JsonProperty(value = "etime")
	private Long etime;
	


	Domain4Json() {
		this.parent_id = null;
	}
}
