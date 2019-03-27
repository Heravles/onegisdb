package cn.ict.onedbcore.entity.db;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.Gson;

import cn.ict.onedbcore.entity.json.object.Position4Json;
import lombok.Data;

@Data
@Entity
@Table(name = "position")
public class Position {
	@EmbeddedId
	private EmbededIdTime indentity;
	private Long object_id;
	private Long trs;
	private Long srs;
	private String geomstr;
	
	public void PositionFromWrapper(Position4Json position4Json, Long object_id,
			Long trsid, Long srsid, Long vtime) {
		this.indentity = new EmbededIdTime();
		this.indentity.setId(position4Json.getId());
		this.indentity.setTime(vtime);
		Gson gson = new Gson();
		this.object_id = object_id;
		if (trsid != 0)
			this.trs = trsid;
		if (srsid != 0)
			this.srs = srsid;
		this.geomstr = gson.toJson(position4Json.getData());
	}

}
