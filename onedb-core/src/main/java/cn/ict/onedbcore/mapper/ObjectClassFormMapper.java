package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.ObjectClassForm;

@Repository
public interface ObjectClassFormMapper extends CrudRepository<ObjectClassForm, Long>{
	
}
