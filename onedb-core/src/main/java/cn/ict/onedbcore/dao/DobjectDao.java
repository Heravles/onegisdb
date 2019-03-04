package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.Dobject;
import cn.ict.onedbcore.mapper.DobjectMapper;

@Service
public class DobjectDao {

	@Autowired
	DobjectMapper dobjectMapper;
	
	public Iterable<Dobject> saveAll(List<Dobject> dobjects){
		return dobjectMapper.saveAll(dobjects);
	}
}
