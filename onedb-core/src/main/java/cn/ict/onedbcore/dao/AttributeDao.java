package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Attribute;
import cn.ict.onedbcore.mapper.AttributeMapper;

@Service
public class AttributeDao {

	@Autowired
	AttributeMapper attributeMapper;
	
	public List<Attribute> saveAll(Collection<Attribute> lists){
		List<Attribute> resultList = new ArrayList<>();
		attributeMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
