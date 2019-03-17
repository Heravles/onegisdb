package cn.ict.onedbcore.entity.db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.object.Form4Object;
import cn.ict.onedbcore.entity.json.object.FormRef;
import cn.ict.onedbcore.enums.SpatialDataTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "objectform")
public class ObjectForm {
	@EmbeddedId
	private EmbededIdTime indentity;
	private Long object_id;
	private String name;
	private Long trs;
	private String formref_name;
	private String formref_desc;
	private String formref_fname;
	private String formref_extension;
	private Integer type;
	//private Integer geotype;
	private Integer dim;
	private Double mingrain;
	private Double maxgrain;
	private Long position_id;
	
	public void FormObjectFromWrapper(Form4Object form4Object, Long object_id, 
			Long trsid, Long vtime, Long position_id) {
		this.indentity = new EmbededIdTime();
		this.indentity.setId(form4Object.getId());
		this.indentity.setTime(vtime);
		this.object_id = object_id;
		this.name = form4Object.getName();
		if (trsid != 0) 
			this.trs = trsid;
		FormRef formRef = form4Object.getFormref();
		if (null != formRef) {
			this.formref_name = formRef.getName();
			this.formref_desc = formRef.getDescription();
			this.formref_fname = formRef.getFname();
			this.formref_extension = formRef.getExtension();
		}
		if (null != form4Object.getType())
			this.type = getType(form4Object.getType());
		this.dim = form4Object.getDim();
		this.mingrain = form4Object.getMingrain();
		this.maxgrain = form4Object.getMaxgrain();
		this.position_id = position_id;
	}

	public Integer getType(String geoType) {
		switch (geoType.toLowerCase()) {
		case "point":
			return SpatialDataTypeEnum.POINT.getValue();
		case "linestring":
			return SpatialDataTypeEnum.LINESTRING.getValue();
		case "polygon":
			return SpatialDataTypeEnum.POLYGON.getValue();
		case "dem":
			return SpatialDataTypeEnum.DEM.getValue();
		case "isohypse":
			return SpatialDataTypeEnum.ISOHYPSE.getValue();
		case "tin":
			return SpatialDataTypeEnum.TIN.getValue();
		case "model":
			return SpatialDataTypeEnum.MODEL.getValue();
		case "ellipsoid":
			return SpatialDataTypeEnum.ELLIPSOID.getValue();
		default:
			return 0;
		}
	}

}
