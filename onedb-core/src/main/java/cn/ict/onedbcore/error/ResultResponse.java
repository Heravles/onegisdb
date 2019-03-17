package cn.ict.onedbcore.error;

import lombok.Data;

@Data
public class ResultResponse<T> {
	Boolean success;
	String type;
	T samplekey;
	Integer count;
	String message;
	
	public ResultResponse (String type) {
		this.success = true;
		this.type = type;
		this.samplekey = null;
		this.count = null;
		this.message = null;
	}
}
