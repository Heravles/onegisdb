package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Attribute;

@Repository
public interface AttributeMapper extends CrudRepository<Attribute, Long>{
	
}
