package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Position;
import cn.ict.onedbcore.mapper.PositionMapper;

@Service
public class PositionDao {

	@Autowired
	PositionMapper PositionMapper;
	
	public Iterable<Position> saveAll(List<Position> positions){
		return PositionMapper.saveAll(positions);
	}
}
