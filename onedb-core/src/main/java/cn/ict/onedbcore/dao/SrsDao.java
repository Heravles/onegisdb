package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Srs;
import cn.ict.onedbcore.mapper.SrsMapper;

@Service
public class SrsDao {

	@Autowired
	SrsMapper srsMapper;
	
	public Iterable<Srs> saveAll(List<Srs> srsList){
		return srsMapper.saveAll(srsList);
	}

	//public List<Long> saveAllTest(List<Srs> srsList){
	//	List<Srs> resultList = new ArrayList<>();
	//	srsMapper.saveAll(srsList).forEach(resultList::add);
	//	System.out.println(resultList);
	//	List<Long> array = new ArrayList<>();
	//	for (Srs srs : resultList) {
	//		array.add(srs.get_id());
	//	}
	//	return array;
	//}
	
	//public Long getIdByCode(String code) {
	//	return srsMapper.getIdByCode(code);
	//}
}
