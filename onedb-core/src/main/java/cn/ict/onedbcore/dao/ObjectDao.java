package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Object;
import cn.ict.onedbcore.mapper.ObjectRepository;

@Service
public class ObjectDao {

	@Autowired
	ObjectRepository objectMapper;
	
	public List<Object> saveAll(Collection<Object> lists){
		List<Object> resultList = new ArrayList<>();
		objectMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
