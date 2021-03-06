package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Domain;

@Repository
public interface DomainMapper extends CrudRepository<Domain, Integer>{
	
}
