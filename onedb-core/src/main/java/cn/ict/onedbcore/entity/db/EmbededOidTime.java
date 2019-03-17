package cn.ict.onedbcore.entity.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmbededOidTime implements Serializable {
	private Long oid;
	private Long time;

}
