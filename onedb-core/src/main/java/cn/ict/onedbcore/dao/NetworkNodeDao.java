package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.NetworkNode;
import cn.ict.onedbcore.mapper.NetworkNodeMapper;

@Service
public class NetworkNodeDao {

	@Autowired
	NetworkNodeMapper networkNodeMapper;
	
	public Iterable<NetworkNode> saveAll(List<NetworkNode> networkNodes){
		return networkNodeMapper.saveAll(networkNodes);
	}
}
