package cn.ict.onedbcore.entity.json.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import cn.ict.onedbcore.enums.SpatialDataTypeEnum;
import cn.ict.onedbcore.model.obj.ObjectFormResult;
import lombok.Data;

@Data
public class Form4Object {
	private Long id;
	private String name;
	@JsonProperty(value = "formRef")
	private FormRef formref;
	private String type;
	private Integer dim;
	@JsonProperty(value = "minGrain")
	private Double mingrain;
	@JsonProperty(value = "maxGrain")
	private Double maxgrain;
	private Position4Json geom;
	
	public void Form4ObjectFromResult(ObjectFormResult objectFormResult) {
		Gson gson = new Gson();
		this.id = objectFormResult.getId();
		FormRef formRef = new FormRef();
		if (null != objectFormResult.getFormref_name())
			formRef.setName(objectFormResult.getFormref_name());
		if (null != objectFormResult.getFormref_desc())
			formRef.setDescription(objectFormResult.getFormref_desc());
		if (null != objectFormResult.getFormref_fname())
			formRef.setFname(objectFormResult.getFormref_fname());
		if (null != objectFormResult.getFormref_extension())
			formRef.setExtension(objectFormResult.getFormref_extension());
		this.formref = formRef;
		this.type = getTypeByCode(objectFormResult.getType());
		this.dim = objectFormResult.getDim();
		this.mingrain = objectFormResult.getMingrain();
		this.maxgrain = objectFormResult.getMaxgrain();
		Position4Json position4Json = new Position4Json();
		position4Json.setId(objectFormResult.getPosition_id());
		if (null != objectFormResult.getGeom()) {
			GeoJson data = gson.fromJson(objectFormResult.getGeom(), GeoJson.class);
			position4Json.setData(data);
		}
		this.geom = position4Json;
	}
	
	public String getTypeByCode(Integer code) {
		switch (code) {
		case 21:
			return SpatialDataTypeEnum.POINT.getType();
		case 22:
			return SpatialDataTypeEnum.LINESTRING.getType();
		case 23:
			return SpatialDataTypeEnum.POLYGON.getType();
		case 30:
			return SpatialDataTypeEnum.DEM.getType();
		case 31:
			return SpatialDataTypeEnum.ISOHYPSE.getType();
		case 33:
			return SpatialDataTypeEnum.TIN.getType();
		case 40:
			return SpatialDataTypeEnum.MODEL.getType();
		case 61:
			SpatialDataTypeEnum.ELLIPSOID.getType();
		case 71:
			return SpatialDataTypeEnum.NODE.getType();
		case 72:
			return SpatialDataTypeEnum.WAY.getType();
		case 73:
			return SpatialDataTypeEnum.RELATION.getType();
		default:
			return "error";
		}
	}
}
