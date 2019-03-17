package cn.ict.onedbcore.entity.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmbededIdTime implements Serializable {
	private Long id;
	private Long time;

}
