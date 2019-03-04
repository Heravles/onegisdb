package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.ObjectForm;

@Repository
public interface ObjectFormMapper extends CrudRepository<ObjectForm, Long>{
	
}
