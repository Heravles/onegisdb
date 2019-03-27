package cn.ict.onedbcore.entity.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmbededObjidVtime implements Serializable {
	private Long object_id;
	private Long vtime;

}
