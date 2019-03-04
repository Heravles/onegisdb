package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.ObjectForm;
import cn.ict.onedbcore.mapper.ObjectFormMapper;

@Service
public class ObjectFormDao {

	@Autowired
	ObjectFormMapper ObjectFormMapper;
	
	public Iterable<ObjectForm> saveAll(List<ObjectForm> objectForms){
		return ObjectFormMapper.saveAll(objectForms);
	}
}
