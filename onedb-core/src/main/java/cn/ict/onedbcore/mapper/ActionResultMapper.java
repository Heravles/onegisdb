package cn.ict.onedbcore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface ActionResultMapper {

	@Select("SELECT * FROM ict_getactionbyvid(#{qids})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByIds(@Param("qids") String qids);
	
}
