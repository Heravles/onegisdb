package cn.ict.onedbcore.enums;

public enum SrsTrsEnum {
    SYSTEM(1,"system"),
    DERIVED(2,"derived");
	private Integer code;
	private String type;
	
	SrsTrsEnum(Integer code, String type) {
		this.code = code;
		this.type = type;
	}
	
	public Integer getCode() {
		return this.code;
	}
}
