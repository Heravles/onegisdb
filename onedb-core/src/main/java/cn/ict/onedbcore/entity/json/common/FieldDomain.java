package cn.ict.onedbcore.entity.json.common;

import java.util.List;

import lombok.Data;

@Data
public class FieldDomain {
	private String type;
	private List<Object> value;
}
