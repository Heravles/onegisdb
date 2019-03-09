package cn.ict.onedbcore.entity.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.ict.onedbcore.entity.json.object.Attribute4Json;
import cn.ict.onedbcore.entity.json.object.Form4Object;
import cn.ict.onedbcore.entity.json.object.NetWork4Json;
import cn.ict.onedbcore.entity.json.object.Node4Json;
import cn.ict.onedbcore.entity.json.object.Otype;
import cn.ict.onedbcore.entity.json.object.Version4Json;
import cn.ict.onedbcore.enums.ObjectTypeEnum;
import cn.ict.onedbcore.model.ObjectResult;
import cn.ict.onedbcore.model.obj.AttributeResult;
import cn.ict.onedbcore.model.obj.NetworkResult;
import cn.ict.onedbcore.model.obj.ObjectFormResult;
import lombok.Data;

@Data
public class Object4Json {
	private Long id;
	private String name;
	private String code;
	private Otype otype;
	private String trs;
	private String srs;
	@JsonProperty(value = "realTime")
	private Long realtime;
	@JsonProperty(value = "geoBox")
	private List<Double> geobox;
	private Long sdomain;
	private Long parent;
	private List<Attribute4Json> attributes;
	private List<Form4Object> forms;
	//private List<Model> models;
	private NetWork4Json network;
	private List<Long> compose;
	@JsonProperty(value = "dataSource")
	private Long datasource;
	@JsonProperty(value = "dataGenerate")
	private List<Long> datagenerate;
	private List<Version4Json> versions;
	
	public void Object4JsonFromResult(ObjectResult objectResult, 
			Map<String, Boolean> tuples) {
		Long vtime = objectResult.getRealtime();
		this.id = objectResult.getId();
		this.name = objectResult.getName();
		this.code = objectResult.getCode();
		Otype otype = new Otype();
		otype.setId(objectResult.getOtype_id());
		otype.setName(objectResult.getOtype_name());
		this.otype = otype;
		this.trs = objectResult.getTrs();
		this.srs = objectResult.getSrs();
		this.realtime = objectResult.getRealtime();
		this.geobox = String2ListDouble(objectResult.getGeobox());
		this.sdomain = objectResult.getSdomain();
		this.parent = objectResult.getParentobject_id();
		this.compose = String2ListLong(objectResult.getCompose());
		this.datasource = objectResult.getDatasource();
		this.datagenerate = String2ListLong(objectResult.getDatagenerate());
		if (tuples.containsKey(ObjectTypeEnum.ATTRIBUTE.getType()) && tuples.get(ObjectTypeEnum.ATTRIBUTE.getType()) == true)
			ConvertAttrResult(objectResult.getAttributes_cur(), vtime);
		if (tuples.containsKey(ObjectTypeEnum.FORM.getType()) && tuples.get(ObjectTypeEnum.FORM.getType()) == true)
			ConverFormResult(objectResult.getForms_cur(), vtime);
		if (tuples.containsKey(ObjectTypeEnum.RELATION.getType()) && tuples.get(ObjectTypeEnum.RELATION.getType()) == true)
			ConvertNetworkResult(objectResult.getNetworknodes_cur(), vtime);
	}
	
	public void ConvertAttrResult(List<AttributeResult> attributeResults, Long vtime) {
		this.attributes = new ArrayList<>();
		for (AttributeResult attributeResult : attributeResults) {
			if (!attributeResult.getTime().equals(vtime))
				continue;
			Attribute4Json attribute4Json = new Attribute4Json();
			attribute4Json.setId(attributeResult.getId());
			attribute4Json.setName(attributeResult.getName());
			attribute4Json.setValue(attributeResult.getValue());
			this.attributes.add(attribute4Json);
		}
	}
	
	public void ConverFormResult(List<ObjectFormResult> objectFormResults, Long vtime) {
		this.forms = new ArrayList<>();
		for (ObjectFormResult objectFormResult : objectFormResults) {
			if (!objectFormResult.getTime().equals(vtime))
				continue;
			Form4Object form4Object = new Form4Object();
			form4Object.Form4ObjectFromResult(objectFormResult);
			this.forms.add(form4Object);
		}
	}
	
	public void ConvertNetworkResult(List<NetworkResult> networkResults, Long vtime) {
		this.network = new NetWork4Json();
		for (NetworkResult networkResult : networkResults) {
			if (!networkResult.getTime().equals(vtime))
				continue;
			Node4Json node4Json = new Node4Json();
			node4Json.Node4JsonFromResult(networkResult);
			this.network.addNode(node4Json);
		}
	}
	
	public List<Long> String2ListLong(String str) {
		List<Long> resultList = new ArrayList<>();
		List<String> sp = Arrays.asList(str.replaceAll("[\\{\\}\\[\\]]", "").split(", "));
		for (String s : sp) {
			if ("".equals(s))
				continue;
			resultList.add(Long.valueOf(s.toString()));
		}
		return resultList;
	}

	public List<Double> String2ListDouble(String str) {
		List<Double> resultList = new ArrayList<>();
		List<String> sp = Arrays.asList(str.replaceAll("[\\[\\]]", "").split(", "));
		for (String s : sp) {
			if ("".equals(s))
				continue;
			resultList.add(Double.valueOf(s.toString()));
		}
		return resultList;
	}
	
	//public long[] getIdList4Attributes() {
	//	long[] array = new long[this.attributes.size()];
	//	for (int i = 0; i < this.attributes.size(); ++i) {
	//		array[i] = this.attributes.get(i).getFid();
	//	}
	//	return array;
	//}

	//public long[] getIdList4Forms() {
	//	long[] array = new long[this.forms.size()];
	//	for (int i = 0; i < this.forms.size(); ++i) {
	//		array[i] = this.forms.get(i).getId();
	//	}
	//	return array;
	//}
	
	public long[] getIdList4Compose() {
		long[] array = new long[this.compose.size()];
		for (int i = 0; i < this.compose.size(); ++i) {
			array[i] = this.compose.get(i);
		}
		return array;
	}

	public long[] getIdList4datagenerate() {
		long[] array = new long[this.datagenerate.size()];
		for (int i = 0; i < this.datagenerate.size(); ++i) {
			array[i] = this.datagenerate.get(i);
		}
		return array;
	}
	
	//public long[] getIdList4Version() {
	//	long[] array = new long[this.forms.size()];
	//	for (int i = 0; i < this.forms.size(); ++i) {
	//		array[i] = this.forms.get(i).getId();
	//	}
	//	return array;
	//}
}
