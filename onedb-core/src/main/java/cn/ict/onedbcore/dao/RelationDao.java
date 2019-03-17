package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Relation;
import cn.ict.onedbcore.mapper.RelationMapper;

@Service
public class RelationDao {

	@Autowired
	RelationMapper relationMapper;
	
	public List<Relation> saveAll(Collection<Relation> lists){
		List<Relation> resultList = new ArrayList<>();
		relationMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
