package cn.ict.onedbcore.entity.json;

import java.util.List;

import cn.ict.onedbcore.entity.json.common.Field4Json;
import lombok.Data;

@Data
public class Relation4Json {
	private Long id;
	private String name;
	private String mappingType;
	private List<Field4Json> fields;
	//private List<Rule> rules;

	public long[] getIdList4Fields() {
		long[] array = new long[this.fields.size()];
		for (int i = 0; i < this.fields.size(); ++i) {
			array[i] = this.fields.get(i).getId();
		}
		return array;
	}
}
