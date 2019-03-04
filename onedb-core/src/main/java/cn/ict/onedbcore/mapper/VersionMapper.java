package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Version;

@Repository
public interface VersionMapper extends CrudRepository<Version, Integer>{
	
}
