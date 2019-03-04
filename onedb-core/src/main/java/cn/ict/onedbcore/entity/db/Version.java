package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Long object_id;
	private Long trs;
	private Long vtime;
	@Type(type = "long-array")
	@Column(
		name = "actions",
		columnDefinition = "bigint[]"
	)
	private long[] actions;

	public void VersionFromWrapper(Version4Json version4Json, Long object_id,
			Long trsid, long[] actions) {
		this.object_id = object_id;
		this.trs = trsid;
		this.vtime = version4Json.getVtime();
		this.actions = actions;
	}
}
