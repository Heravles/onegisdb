package cn.ict.onedbcore.enums;

public enum ActionTypeEnum {
    ADD(1,"adding"),
	DELETE(2,"delete"),
    MODIFY(4,"modify");
	private Integer value;
	private String type;
	
	ActionTypeEnum(Integer value, String type) {
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
