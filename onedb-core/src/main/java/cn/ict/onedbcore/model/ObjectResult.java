package cn.ict.onedbcore.model;

import java.util.List;

import javax.persistence.Id;

import cn.ict.onedbcore.model.obj.AttributeResult;
import cn.ict.onedbcore.model.obj.NetworkResult;
import cn.ict.onedbcore.model.obj.ObjectFormResult;
import cn.ict.onedbcore.model.obj.VersionResult;
import lombok.Data;

@Data
public class ObjectResult {
	
	private Long pid;
	@Id
	private Long id;
	private String name;
	private String code;
	private Long otype_id;
	private String otype_name;
	private String trs;
	private String srs;
	private Long realtime;
	private String geobox;
	private Long sdomain;
	private Long parentobject_id;
	private String compose;
	private Long datasource;
	private String datagenerate;
	private List<AttributeResult> attributes_cur;
	private List<ObjectFormResult> forms_cur;
	private List<NetworkResult> networknodes_cur;
	private List<VersionResult> versions_cur;
}
