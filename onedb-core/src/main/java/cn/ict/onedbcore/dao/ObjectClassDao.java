package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.ObjectClass;
import cn.ict.onedbcore.mapper.ObjectClassMapper;

@Service
public class ObjectClassDao {

	@Autowired
	ObjectClassMapper objectClassMapper;
	
	public Iterable<ObjectClass> saveAll(List<ObjectClass> objectClasses){
		return objectClassMapper.saveAll(objectClasses);
	}
}
