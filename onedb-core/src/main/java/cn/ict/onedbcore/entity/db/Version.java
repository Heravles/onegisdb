package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import cn.ict.onedbcore.entity.json.object.Version4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "objectversion")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class Version {
	@EmbeddedId
	private EmbededObjidVtime identity;
	private Long trs;
	@Type(type = "long-array")
	@Column(
		name = "actions",
		columnDefinition = "bigint[]"
	)
	private long[] actions;

	public void VersionFromWrapper(Version4Json version4Json, Long object_id,
			Long trsid, long[] actions) {
		this.identity = new EmbededObjidVtime();
		this.identity.setObject_id(object_id);
		this.trs = trsid;
		this.identity.setVtime(version4Json.getVtime());
		this.actions = actions;
	}
}
