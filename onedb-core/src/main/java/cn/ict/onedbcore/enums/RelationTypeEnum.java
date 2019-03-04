package cn.ict.onedbcore.enums;

public enum RelationTypeEnum {
    REALIZATION(2,"realization"),
    AGGREGATION(4,"aggregation"),
	COMPOSITION(8,"composition"),
	DEPENDENCY(16,"dependency"),
	ASSOCIATION(32,"association");
	private Integer value;
	private String type;
	
	RelationTypeEnum(Integer value, String type) {
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
