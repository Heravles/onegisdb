package cn.ict.onedbcore.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Field;
import cn.ict.onedbcore.mapper.FieldMapper;

@Service
public class FieldDao {

	@Autowired
	FieldMapper fieldMapper;
	
	public Iterable<Field> saveAll(Collection<Field> fields){
		return fieldMapper.saveAll(fields);
	}
}
