package cn.ict.onedbcore.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface SRSTRSMapper {

	@Select("SELECT * FROM getTrsIdByCode(#{code})")
	@ResultType(Long.class)
	@Options(statementType = StatementType.CALLABLE)
	public Long getTrsIdByCode(@Param("code") String code);

	@Select("SELECT * FROM getSrsIdByCode(#{code})")
	@ResultType(Long.class)
	@Options(statementType = StatementType.CALLABLE)
	public Long getSrsIdByCode(@Param("code") String code);
}
