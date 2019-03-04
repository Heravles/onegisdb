package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Trs;
import cn.ict.onedbcore.mapper.TrsMapper;

@Service
public class TrsDao {

	@Autowired
	TrsMapper trsMapper;
	
	public Iterable<Trs> saveAll(List<Trs> trsList){
		return trsMapper.saveAll(trsList);
	}

	//public Long getIdByCode(String code) {
	//	return trsMapper.getIdByCode(code);
	//}
}
