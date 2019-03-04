package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Relation;
import cn.ict.onedbcore.mapper.RelationMapper;

@Service
public class RelationDao {

	@Autowired
	RelationMapper relationMapper;
	
	public Iterable<Relation> saveAll(List<Relation> relations){
		return relationMapper.saveAll(relations);
	}
}
