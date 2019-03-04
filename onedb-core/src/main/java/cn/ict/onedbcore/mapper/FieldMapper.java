package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Field;

@Repository
public interface FieldMapper extends CrudRepository<Field, Long>{
	
}
