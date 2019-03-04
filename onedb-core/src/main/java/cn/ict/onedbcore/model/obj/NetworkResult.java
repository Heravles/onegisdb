package cn.ict.onedbcore.model.obj;

import lombok.Data;

@Data
public class NetworkResult {
	private Long pid;
	private Long object_id;
	private String properties;
	private Long refobject_id;
	private String refobject_name;
	private Long refotype_id;
	private String refotype_name;
	private String edge_label;
	private Long edgerelation_id;
	private String edgerelation_name;
	private Integer intensity;
	private String trs;
	private Long time;
}
