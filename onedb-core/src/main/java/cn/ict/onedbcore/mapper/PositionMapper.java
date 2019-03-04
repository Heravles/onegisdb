package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Position;

@Repository
public interface PositionMapper extends CrudRepository<Position, Long>{
	
}
