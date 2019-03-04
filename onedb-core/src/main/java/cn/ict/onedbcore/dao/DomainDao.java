package cn.ict.onedbcore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Domain;
import cn.ict.onedbcore.mapper.DomainMapper;

@Service
public class DomainDao {

	@Autowired
	DomainMapper domainMapper;
	
	public Iterable<Domain> saveAll(List<Domain> domains){
		return domainMapper.saveAll(domains);
	}
}
