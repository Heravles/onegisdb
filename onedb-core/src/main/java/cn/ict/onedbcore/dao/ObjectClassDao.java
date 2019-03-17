package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.ObjectClass;
import cn.ict.onedbcore.mapper.ObjectClassMapper;

@Service
public class ObjectClassDao {

	@Autowired
	ObjectClassMapper objectClassMapper;
	
	public List<ObjectClass> saveAll(Collection<ObjectClass> lists){
		List<ObjectClass> resultList = new ArrayList<>();
		objectClassMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
