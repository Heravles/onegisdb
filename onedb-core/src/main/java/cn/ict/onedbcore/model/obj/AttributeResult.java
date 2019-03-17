package cn.ict.onedbcore.model.obj;

import javax.persistence.Id;

import lombok.Data;

@Data
public class AttributeResult {
	private Long pid;
	@Id
	private Long id;
	private Long object_id;
	private String name;
	private String value;
	private String trs;
	private Long time;
}
