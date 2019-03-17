package cn.ict.onedbcore.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * 
 * 其他功能函数访问接口
 * @author ict
 *
 */
public interface FeaturesMapper {

	/**
	 * 查询所有多粒度时空对象的名称和id
	 * @return
	 */
	@Select("SELECT * FROM get_obj_baseinfo()")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Map.class)
	public List<Map<String, Object> > getObjectBaseInfo();

	/**
	 * 查询指定对象的子id
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM get_sub_obj_id(#{id})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Long.class)
	public List<Long> getSubObjectId(@Param("id") int id);

	/**
	 * 查询对象的父id
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM get_parent_obj_id(#{id})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Long.class)
	public Long getParentObjId(@Param("id") int id);

	@Select("SELECT * FROM get_objid_by_order(#{pageNum}, #{pageSize}, #{orderType}, #{descOrAsc})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Long.class)
	public List<Long> getObjIdByPage(@Param("pageNum") int pageNum,
									@Param("pageSize") int pageSize,
									@Param("orderType") int orderType,
									@Param("descOrAsc") boolean descOrAsc);
		
	@Select("SELECT * FROM get_objid_by_order(#{pageNum}, #{pageSize}, #{orderType}, #{descOrAsc}, #{timefilter})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(Long.class)
	public List<Long> getObjIdByPageAndTime(@Param("pageNum") int pageNum,
									@Param("pageSize") int pageSize,
									@Param("orderType") int orderType,
									@Param("descOrAsc") boolean descOrAsc,
									@Param("timefilter") Timestamp timefilter);

}
