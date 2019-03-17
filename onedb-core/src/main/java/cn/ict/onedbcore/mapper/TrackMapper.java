package cn.ict.onedbcore.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.TrackData;

@Repository
public interface TrackMapper extends CrudRepository<TrackData, Long>{
	
}
