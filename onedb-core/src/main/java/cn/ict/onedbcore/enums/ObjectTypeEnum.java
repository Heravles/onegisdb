package cn.ict.onedbcore.enums;

public enum ObjectTypeEnum {
    BASE(32,"base"),
	ATTRIBUTE(64,"attribute"),
    FORM(128,"form"),
	RELATION(256,"relation"),
	COMPOSE(512,"compose"),
	MODEL(1024,"model"),
	REFERENCE(2048,"reference");
	private Integer value;
	private String type;
	
	ObjectTypeEnum(Integer value, String type) {
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
