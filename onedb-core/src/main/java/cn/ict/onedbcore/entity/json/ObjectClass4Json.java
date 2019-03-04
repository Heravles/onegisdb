package cn.ict.onedbcore.entity.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ict.onedbcore.entity.json.common.Field4Json;
import cn.ict.onedbcore.entity.json.objectclass.Connector4Json;
import cn.ict.onedbcore.entity.json.objectclass.Form4Class;
import lombok.Data;

@Data
public class ObjectClass4Json {
	private Long id;
	private String name;
	@JsonProperty(value = "desc")
	private String description;
	private String srs;
	private String trs;
	private List<Field4Json> fields;
	private List<Form4Class> forms;
	private List<Connector4Json> connectors;
	//private List<Long> models;
	
	public long[] getIdList4Fields() {
		long[] array = new long[this.fields.size()];
		for (int i = 0; i < this.fields.size(); ++i) {
			array[i] = this.fields.get(i).getId();
		}
		return array;
	}

	public long[] getIdList4Forms() {
		long[] array = new long[this.forms.size()];
		for (int i = 0; i < this.forms.size(); ++i) {
			array[i] = this.forms.get(i).getId();
		}
		return array;
	}

	public long[] getIdList4Connectors() {
		long[] array = new long[this.connectors.size()];
		for (int i = 0; i < this.connectors.size(); ++i) {
			array[i] = this.connectors.get(i).getId();
		}
		return array;
	}
}
