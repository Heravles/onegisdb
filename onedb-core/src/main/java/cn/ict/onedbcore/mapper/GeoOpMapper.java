package cn.ict.onedbcore.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface GeoOpMapper {

	@Select("SELECT * FROM ict_geom_contains(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Contains(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_intersect(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Intersects(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_overlaps(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Overlaps(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_touches(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Touches(@Param("wkt1") String wkt1, @Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_distance(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Double.class)
	public Double Distance(@Param("wkt1") String wkt1, @Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_dwithin(#{wkt1},#{wkt2},#{dis})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Double.class)
	public Integer DWithin(@Param("wkt1") String wkt1, @Param("wkt2") String wkt2,
			 @Param("dis") double dis);

	@Select("SELECT * FROM ict_geom_euqals(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Equals(@Param("wkt1") String wkt1, @Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_disjoint(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Disjoint(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_crosses(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer Crosses(@Param("wkt1") String wkt1, @Param("wkt2") String wkt2);

	@Select("SELECT * FROM ict_geom_area(#{wkt1})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Double.class)
	public Double Area(@Param("wkt1") String wkt1);

	@Select("SELECT * FROM ict_geom_length(#{wkt1})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Double.class)
	public Double Length(@Param("wkt1") String wkt1);

	@Select("SELECT * FROM ict_geom_centroid(#{wkt1})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(String.class)
	public String Centroid(@Param("wkt1") String wkt1);

	@Select("SELECT * FROM ict_geom_union(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(String.class)
	public String Union(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);
	
	@Select("SELECT * FROM ict_geom_intersection(#{wkt1},#{wkt2})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(String.class)
	public String Intersection(@Param("wkt1") String wkt1,	@Param("wkt2") String wkt2);
	
	@Select("SELECT * FROM ict_geom_isclosed(#{wkt1})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Integer.class)
	public Integer IsClosed(@Param("wkt1") String wkt1);
}
