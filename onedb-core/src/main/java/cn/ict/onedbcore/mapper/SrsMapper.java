package cn.ict.onedbcore.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Srs;

@Repository
public interface SrsMapper extends CrudRepository<Srs, Integer>{
	
}
