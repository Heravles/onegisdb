package cn.ict.onedbcore.entity.json;

import java.util.List;

import cn.ict.onedbcore.entity.json.srstrs.Derived;
import cn.ict.onedbcore.entity.json.srstrs.SystemCell;
import lombok.Data;

@Data
public class SrsTrs {
	List<SystemCell> system;
	List<Derived> derived; 
}
