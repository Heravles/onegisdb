package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Trs;
import cn.ict.onedbcore.mapper.TrsMapper;

@Service
public class TrsDao {

	@Autowired
	TrsMapper trsMapper;

	public List<Trs> saveAll(Collection<Trs> lists){
		List<Trs> resultList = new ArrayList<>();
		trsMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
	//public Long getIdByCode(String code) {
	//	return trsMapper.getIdByCode(code);
	//}
}
