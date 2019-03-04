package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.ObjectClass;

@Repository
public interface ObjectClassMapper extends CrudRepository<ObjectClass, Long>{
	
}
