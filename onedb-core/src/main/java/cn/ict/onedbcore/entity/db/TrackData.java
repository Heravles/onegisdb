package cn.ict.onedbcore.entity.db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="objecttrack")
public class TrackData {
	@EmbeddedId
	EmbededOidTime indentity;
	private Double x;
	private Double y;
	private Double z;
	private Double speed_kilometer;
	private Double height_meter;
	private Double heading_degree;
	
	public void setTrackData(String[] datas) {
		this.indentity = new EmbededOidTime();
		this.indentity.setOid(Long.valueOf(datas[0]).longValue());
		this.x = Double.valueOf(datas[1]).doubleValue();
		this.y = Double.valueOf(datas[2]).doubleValue();
		this.z = Double.valueOf(datas[3]).doubleValue();
		this.indentity.setOid(Long.valueOf(datas[4]).longValue());
		this.speed_kilometer = Double.valueOf(datas[5]).doubleValue();
		this.height_meter = Double.valueOf(datas[6]).doubleValue();
		this.heading_degree = Double.valueOf(datas[7]).doubleValue();
	}
}
