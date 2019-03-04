package cn.ict.onedbcore.entity.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

import cn.ict.onedbcore.entity.json.object.Position4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Long id;
	private Long object_id;
	private Long trs;
	private Long srs;
	private Long time;
	private String geom;
	
	public void PositionFromWrapper(Position4Json position4Json, Long object_id,
			Long trsid, Long srsid, Long vtime) {
		Gson gson = new Gson();
		this.id = position4Json.getId();
		this.object_id = object_id;
		if (trsid != 0)
			this.trs = trsid;
		if (srsid != 0)
			this.srs = srsid;
		this.time = vtime;
		this.geom = gson.toJson(position4Json.getData());
	}

}
