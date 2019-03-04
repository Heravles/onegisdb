package cn.ict.onedbcore.mapper;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface Position2Mapper {

	@Select("SELECT * FROM get_position_result(#{id})")
	@Options(statementType=StatementType.CALLABLE)
	@ResultType(Map.class)
	public Map<String, Object> getOne(@Param("id") int id);
	
	@Select("SELECT * FROM get_position_result(#{id}, #{timefilter})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public Map<String, Object> getByIdAndTime(@Param("id") int id, @Param("timefilter") Timestamp timefilter);
}
