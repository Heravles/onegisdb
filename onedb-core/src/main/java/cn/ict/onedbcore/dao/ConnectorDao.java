package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Connector;
import cn.ict.onedbcore.mapper.ConnectorMapper;

@Service
public class ConnectorDao {

	@Autowired
	ConnectorMapper connectorMapper;
	
	public Iterable<Connector> saveAll(List<Connector> connectors){
		return connectorMapper.saveAll(connectors);
	}
}
