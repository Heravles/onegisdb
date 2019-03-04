package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.Dobject;

@Repository
public interface DobjectMapper extends CrudRepository<Dobject, Long>{
	
}
