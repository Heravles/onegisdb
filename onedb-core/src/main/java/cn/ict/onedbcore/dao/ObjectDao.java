package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Object;
import cn.ict.onedbcore.mapper.ObjectRepository;

@Service
public class ObjectDao {

	@Autowired
	ObjectRepository objectMapper;
	
	public Iterable<Object> saveAll(List<Object> objects){
		return objectMapper.saveAll(objects);
	}
}
