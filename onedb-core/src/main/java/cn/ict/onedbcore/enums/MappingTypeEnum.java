package cn.ict.onedbcore.enums;

public enum MappingTypeEnum {
    OneToOne(1,"oneToOne"),
    OneToMany(2,"oneToMany"),
	ManyToOne(3,"manyToOne"),
	ManyToMany(4,"manyToMany");
	private Integer code;
	private String type;
	
	MappingTypeEnum(Integer code, String type) {
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
