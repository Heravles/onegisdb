package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Version;
import cn.ict.onedbcore.mapper.VersionMapper;

@Service
public class VersionDao {

	@Autowired
	VersionMapper versionMapper;
	
	public long[] saveAll(List<Version> versions){
		List<Version> resultList = new ArrayList<>();
		versionMapper.saveAll(versions).forEach(resultList::add);
		long[] array = new long[resultList.size()];
		for (int i = 0; i < resultList.size(); ++i) {
			array[i] = resultList.get(i).getIdentity().getObject_id();
		}
		return array;
	}
}
