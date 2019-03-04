package cn.ict.onedbcore.model.obj;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ObjectFormResult {
	private Long pid;
	@Id
	private Long id;
	private String name;
	private Long object_id;
	private String trs;
	private Long time;
	private String formref_name;
	private String formref_desc;
	private String formref_fname;
	private String formref_extension;
	private Integer type;
	private Integer dim;
	private Double mingrain;
	private Double maxgrain;
	private String srs;
	private Long position_id;
	private String geom;
}
