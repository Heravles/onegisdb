package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.ObjectClassForm;
import cn.ict.onedbcore.mapper.ObjectClassFormMapper;

@Service
public class ObjectClassFormDao {

	@Autowired
	ObjectClassFormMapper objectClassFormMapper;
	
	public Iterable<ObjectClassForm> saveAll(List<ObjectClassForm> objectClassForms){
		return objectClassFormMapper.saveAll(objectClassForms);
	}
}
