package cn.ict.onedbcore.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface GeoOpMapper {
	

	@Select("SELECT * FROM get_object_by_geom(#{wkt}, #{op}, #{srsid}, #{timefilter})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public List<Map<String, Object>> getObjectByGeom(@Param("wkt") String wkt,
			@Param("op") String op, @Param("srsid") int srsid,
			@Param("timefilter") Timestamp timefilter);
}
