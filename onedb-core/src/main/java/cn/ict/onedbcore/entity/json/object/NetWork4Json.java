package cn.ict.onedbcore.entity.json.object;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NetWork4Json {
	List<Node4Json> nodes;
	
	public NetWork4Json() {
		this.nodes = new ArrayList<>();
	}

	public void addNode(Node4Json node4Json) {
		this.nodes.add(node4Json);
	}
	
	//public long[] getNodeIdList() {
	//	long[] array = new long[this.nodes.size()];
	//	for (int i = 0; i < this.nodes.size(); ++i) {
	//		array[i] = this.nodes.get(i).getRefobject().getId();
	//	}
	//	return array;
	//}
}
