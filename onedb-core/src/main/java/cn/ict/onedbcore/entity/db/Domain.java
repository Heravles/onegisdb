package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.ict.onedbcore.entity.json.Domain4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "domain")
public class Domain {
	@Id
	private Long id;
	private String name;
	private String description;
	private Long parent_id;	
	private Long trs;
	private Long srs;
	private String geobox;
	private Long stime;
	private Long etime;
	
	public Domain() {
		this.parent_id = null;
	}
	
	public void DomainFromWrapper(Domain4Json domain4Json, Long trsid, Long srsid) {
		this.id = domain4Json.getId();
		this.name = domain4Json.getName();
		this.description = domain4Json.getDescription();
		this.parent_id = domain4Json.getParent_id();
		this.trs = trsid;
		this.srs = srsid;
		if (null != domain4Json.getGeobox()) 
			this.geobox = domain4Json.getGeobox().toString();
		this.stime = domain4Json.getStime();
		this.etime = domain4Json.getEtime();
	}
}
