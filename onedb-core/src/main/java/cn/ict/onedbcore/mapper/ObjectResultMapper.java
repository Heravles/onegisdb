package cn.ict.onedbcore.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface ObjectResultMapper {

	/**
	 * 根据id获取查询结果
	 * @param id
	 * @return
	 */

	@Select("SELECT * FROM ict_searchobjectbydomain(#{sdomain})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByDomain(@Param("sdomain") long sdomain);

	@Select("SELECT * FROM ict_searchobject(#{id})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryById(@Param("id") long id);

	@Select("SELECT * FROM ict_searchobject(#{name})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object>> queryByName(@Param("name") String name);

	@Select("SELECT * FROM ict_searchobject(#{id}, #{name})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByIdAndName(@Param("id") long id, @Param("name") String name);

	@Select("SELECT * FROM ict_searchobject(#{id},#{name},#{begintime},#{endtime},#{wkt},#{trs},#{srs})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByIdAndNameAndTS(@Param("id") String id,
			@Param("name") String name,
			@Param("begintime") long begintime,
			@Param("endtime") long endtime,
			@Param("wkt") String wkt,
			@Param("trs") long trs,
			@Param("srs") long srs);
	
	@Select("SELECT * FROM get_object_cell(#{id})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public Map<String, Object> getById(@Param("id") int id);
	

	@Select("SELECT * FROM get_object_list(#{pageNum}, #{pageSize}, #{orderType}, #{descOrAsc})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public List<Map<String, Object>> getAllByPage(@Param("pageNum") int pageNum, 
				@Param("pageSize") int pageSize, @Param("orderType") int orderType,
				@Param("descOrAsc") boolean descOrAsc);
		
	@Select("SELECT * FROM get_object_list(#{pageNum}, #{pageSize}, #{orderType}, #{descOrAsc}, #{timefilter})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public List<Map<String, Object>> getAllByTimeAndPage(@Param("pageNum") int pageNum, 
				@Param("pageSize") int pageSize, @Param("orderType") int orderType,
				@Param("descOrAsc") boolean descOrAsc, 
				@Param("timefilter") Timestamp timefilter);

	@Select("SELECT * FROM get_object_list(#{pageNum}, #{pageSize}, #{orderType}, #{descOrAsc}, #{timefilter}"
			+ ", #{condName}, #{condType})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public List<Map<String, Object>> getAllByTimeAndCondAndPage(@Param("pageNum") int pageNum, 
				@Param("pageSize") int pageSize, @Param("orderType") int orderType,
				@Param("descOrAsc") boolean descOrAsc, 
				@Param("timefilter") Timestamp timefilter,
				@Param("condName") String condName,
				@Param("condType") String condType);

}
