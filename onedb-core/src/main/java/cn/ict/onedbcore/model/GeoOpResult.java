package cn.ict.onedbcore.model;

import lombok.Data;

@Data
public class GeoOpResult {
	
	private long object_id;
	private String type;
	private String date;
	private String position;
	
	@Override
	public String toString() {
		return "GeoOpResult [object_id=" + object_id + ", type=" + type 
				+ ", date=" + date + ", position=" + position + "]";
	}
	
}
 