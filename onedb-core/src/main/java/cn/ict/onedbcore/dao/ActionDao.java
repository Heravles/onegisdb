package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Action;
import cn.ict.onedbcore.mapper.ActionMapper;

@Service
public class ActionDao {

	@Autowired
	ActionMapper actionMapper;
	
	public long[] saveAll(List<Action> actions){
		List<Action> resultList = new ArrayList<>();
		actionMapper.saveAll(actions).forEach(resultList::add);
		//List<Long> array = new ArrayList<>();
		//for (Action action : resultList) {
		//	array.add(action.get_id());
		//}
		long[] array = new long[resultList.size()];
		for (int i = 0; i < resultList.size(); ++i) {
			array[i] = resultList.get(i).get_id();
		}
		return array;
	}
}
