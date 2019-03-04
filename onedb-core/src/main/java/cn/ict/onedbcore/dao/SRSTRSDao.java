package cn.ict.onedbcore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ict.onedbcore.mapper.SRSTRSMapper;

@Service
public class SRSTRSDao {
	
	@Autowired
	private SRSTRSMapper srstrsMapper;
	
	public Long getTrsIdByCode(String trs) {
		if (trs != null) {
			return srstrsMapper.getTrsIdByCode(trs);
		} else {
			return 0L;
		}
	}

	public Long getSrsIdByCode(String srs) {
		if (srs != null) {
			return srstrsMapper.getSrsIdByCode(srs);
		} else {
			return 0L;
		}
	}
}
