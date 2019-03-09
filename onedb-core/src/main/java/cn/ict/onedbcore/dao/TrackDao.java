package cn.ict.onedbcore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.entity.db.Track;
import cn.ict.onedbcore.mapper.TrackMapper;

@Service
public class TrackDao {

	@Autowired
	TrackMapper trackMapper;
	
	public List<Track> saveAll(List<Track> tracks){
		List<Track> resultList = new ArrayList<>();
		trackMapper.saveAll(tracks).forEach(resultList::add);
		return resultList;
	}
}
