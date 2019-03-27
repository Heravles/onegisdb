package cn.ict.onedbcore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface TrackResultMapper {

	@Select("SELECT * FROM ict_searchtrackbyid(#{id})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > querytrackById(@Param("id") long id);

	@Select("SELECT * FROM ict_searchtrackbyts(#{id},#{begintime},#{endtime},#{wkt},"
			+ "#{trs},#{srs})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > querytrackByIdAndTS(@Param("id") String id, 
			@Param("begintime") long begintime, @Param("endtime") long endtime,
			@Param("wkt") String wkt, @Param("trs") long trs, @Param("srs") long srs);

	@Select("update objecttrack set geom = st_makepointm(x,y,z) where geom is null")
	@Options(statementType = StatementType.CALLABLE)
	public void updateGeom();
}
