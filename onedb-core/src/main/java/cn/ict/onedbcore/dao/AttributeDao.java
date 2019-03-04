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
	
	public List<Long> saveAll(Collection<Attribute> attributes){
		List<Attribute> resultList = new ArrayList<>();
		attributeMapper.saveAll(attributes).forEach(resultList::add);
		List<Long> array = new ArrayList<>();
		for (Attribute attribute : resultList) {
			array.add(attribute.get_id());
		}
		return array;
	}
}
