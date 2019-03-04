package cn.ict.onedbcore.entity.json.object;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Operation {
	@JsonProperty(value = "actionOperationType")
	private String actionoperationtype;
	@JsonProperty(value = "objectOperationType")
	private String objectoperationtype;
}
