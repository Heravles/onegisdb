package cn.ict.onedbcore.entity.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmbededThreeKey implements Serializable {
	private Long object_id;
	private Long time;
	private Long refobject_id;

}
