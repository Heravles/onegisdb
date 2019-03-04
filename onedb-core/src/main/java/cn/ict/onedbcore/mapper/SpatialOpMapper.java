package cn.ict.onedbcore.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface SpatialOpMapper {
	
	@Select("SELECT * FROM geom_rela_op(#{wkt_parm1}, #{wkt_parm2}, #{len}, #{op})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Float.class)
	public float geomRelaOp(@Param("wkt_parm1") String wkt_parm1, @Param("wkt_parm2") String wkt_parm2,
			@Param("len") float len, @Param("op") String op);
}
