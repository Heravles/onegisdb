package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.objectclass.Form4Class;
import cn.ict.onedbcore.enums.SpatialDataTypeEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "objectclassform")
public class ObjectClassForm {
	@Id
	private Long id;
	private String name;
	private Integer type;
	//private Integer geotype;
	private Integer dim;
	private Double mingrain;
	private Double maxgrain;
	
	public void FormFromClassWrapper(Form4Class form4Class) {
		this.id = form4Class.getId();
		this.name = form4Class.getName();
		if (null != form4Class.getType()) {
			this.type = getType(form4Class.getType());
		}
		//this.geotype = getType(form4Class.getGeotype());
		this.dim = form4Class.getDim();
		this.mingrain = form4Class.getMingrain();
		this.maxgrain = form4Class.getMaxgrain();
	}

	public Integer getType(String strtype) {
		switch (strtype) {
		case "point":
			return SpatialDataTypeEnum.POINT.getValue();
		case "lineString":
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
