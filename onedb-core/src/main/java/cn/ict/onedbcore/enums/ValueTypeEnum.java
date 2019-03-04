package cn.ict.onedbcore.enums;

public enum ValueTypeEnum {
    SHORT(1,"short"),
    INT(2,"int"),
	LONG(3,"long"),
	FLOAT(4,"float"),
	DOUBLE(5,"double"),
	TEXT(6,"text"),
	DATETIME(7,"datetime"),
	BOOLEAN(8,"boolean");
	private Integer code;
	private String type;
	
	ValueTypeEnum(Integer code, String type) {
		this.code = code;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

	public Integer getCode() {
		return this.code;
	}
}
