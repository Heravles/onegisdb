package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.Object4Json;
import cn.ict.onedbcore.entity.json.object.Otype;
import lombok.Data;

@Data
@Entity
@Table(name = "object")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class Object {
	@Id
	private Long id;
	private String name;
	private String code;
	private Long otype_id;
	private String otype_name;
	private Long trs;
	private Long srs;
	private Long realtime;
	private String geobox;
	private Long sdomain;
	private Long parentobject_id;
	@Type(type = "long-array")
	@Column(
		name = "attributes",
		columnDefinition = "bigint[]"
	)
	private long[] attributes;
	@Type(type = "long-array")
	@Column(
		name = "forms",
		columnDefinition = "bigint[]"
	)
	private long[] forms;
	//@Type(type = "long-array")
	//@Column(
	//	name = "models",
	//	columnDefinition = "bigint[]"
	//)
	//private long[] models;
	private Long network;
	@Type(type = "long-array")
	@Column(
		name = "compose",
		columnDefinition = "bigint[]"
	)
	private long[] compose;
	private Long datasource;
	@Type(type = "long-array")
	@Column(
		name = "datagenerate",
		columnDefinition = "bigint[]"
	)
	private long[] datagenerate;
	@Type(type = "long-array")
	@Column(
		name = "versions",
		columnDefinition = "bigint[]"
	)
	private long[] versions;
	
	public void ObjectFromWrapper(Object4Json object4Json, Long trsid, Long srsid) {
		this.id = object4Json.getId();
		this.name = object4Json.getName();
		this.code = object4Json.getCode();
		Otype otype = object4Json.getOtype();
		if (null != otype) {
			this.otype_id = otype.getId();
			this.otype_name = otype.getName();
		}
		this.trs = trsid;
		this.srs = srsid;
		this.realtime = object4Json.getRealtime();
		if (null != object4Json.getGeobox()) 
			this.geobox = object4Json.getGeobox().toString();
		this.sdomain = object4Json.getSdomain();
		//this.attributes = object4Json.getIdList4Attributes();
		//this.forms = object4Json.getIdList4Forms();
		//if (networkId != 0) {
		//	this.network = networkId;
		//} else {
		//	this.network = 0L;
		//}
		this.compose = object4Json.getIdList4Compose();
		this.datasource = object4Json.getDatasource();
		this.datagenerate = object4Json.getIdList4datagenerate();
		//this.versions = object4Json.getIdList4Version();
	}
}
