package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.Dobject;
import cn.ict.onedbcore.mapper.DobjectMapper;

@Service
public class DobjectDao {

	@Autowired
	DobjectMapper dobjectMapper;
	
	public List<Dobject> saveAll(Collection<Dobject> lists){
		List<Dobject> resultList = new ArrayList<>();
		dobjectMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
