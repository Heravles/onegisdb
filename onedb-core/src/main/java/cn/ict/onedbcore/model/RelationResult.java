package cn.ict.onedbcore.model;

import lombok.Data;

@Data
public class RelationResult {
	
	private Long refobj_id;
	private String refobj_name;
	private Long refotype_id;
	private String refotype_name;
}
