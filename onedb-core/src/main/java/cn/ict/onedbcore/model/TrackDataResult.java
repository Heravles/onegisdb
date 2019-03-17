package cn.ict.onedbcore.model;

import lombok.Data;

@Data
public class TrackDataResult {
	private Long pid;
	private Long oid;
	private Double x;
	private Double y;
	private Double z;
	private Long time;
	private Double speed_kilometer;
	private Double height_meter;
	private Double heading_degree;

}
