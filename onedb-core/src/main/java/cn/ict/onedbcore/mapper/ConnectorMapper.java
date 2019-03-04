package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Connector;

@Repository
public interface ConnectorMapper extends CrudRepository<Connector, Long>{
	
}
