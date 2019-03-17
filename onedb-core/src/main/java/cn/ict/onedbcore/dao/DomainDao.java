package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Domain;
import cn.ict.onedbcore.mapper.DomainMapper;

@Service
public class DomainDao {

	@Autowired
	DomainMapper domainMapper;

	public List<Domain> saveAll(Collection<Domain> lists){
		List<Domain> resultList = new ArrayList<>();
		domainMapper.saveAll(lists).forEach(resultList::add);
		return resultList;
	}
}
