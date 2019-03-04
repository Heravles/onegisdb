package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.NetworkNode;

@Repository
public interface NetworkNodeMapper extends CrudRepository<NetworkNode, Long>{
	
}
