package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Action;

@Repository
public interface ActionMapper extends CrudRepository<Action, Long>{
	
}
