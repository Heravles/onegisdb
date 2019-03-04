package cn.ict.onedbcore.model.obj;

import lombok.Data;

@Data
public class VersionResult {
	private Long pid;
	private Long object_id;
	private String trs;
	private Long vtime;
	private String actions;
	
	public String GetActionsString() {
		String str = this.actions.replaceAll("[\\{\\}]", "");
		return str;
	}

}
