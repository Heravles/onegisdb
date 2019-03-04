package cn.ict.onedbcore.model.obj;

import lombok.Data;

@Data
public class ActionResult {
	private Long pid;
	private Long operation_id;
	private Integer actionoperation;
	private Integer objectoperation;
}
