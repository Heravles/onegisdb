package cn.ict.onedbcore.enums;

public enum SpatialDataTypeEnum {
    POINT(21,"point"),
    LINESTRING(22,"linestring"),
	POLYGON(23,"polygon"), 
	DEM(30,"dem"),
	ISOHYPSE(31,"isohypse"),
    TIN(33,"tin"),
    MODEL(40,"model"),
	ELLIPSOID(61,"ellipsoid"), 
	NODE(71,"node"),
	WAY(72,"way"),
	RELATION(73,"relation");

	private Integer value;
	private String type;
	
	SpatialDataTypeEnum(Integer value, String type) {
		this.value = value;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

	public Integer getValue() {
		return this.value;
	}
}
