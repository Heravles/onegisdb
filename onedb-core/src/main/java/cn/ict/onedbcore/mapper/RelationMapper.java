package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Relation;

@Repository
public interface RelationMapper extends CrudRepository<Relation, Long>{
	
}
