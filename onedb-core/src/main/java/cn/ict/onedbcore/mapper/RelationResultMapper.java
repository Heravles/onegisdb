package cn.ict.onedbcore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface RelationResultMapper {

	@Select("SELECT * FROM ict_relation(#{id},#{dep})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByIdAndDep(@Param("id") long id, @Param("dep") int dep);

	@Select("SELECT * FROM ict_relation(#{id},#{relation},#{dep})")
	@ResultType(Map.class)
	@Options(statementType = StatementType.CALLABLE)
	public List<Map<String, Object> > queryByIdAndRelationAndDep(@Param("id") long id, 
			@Param("relation") long relation, @Param("dep") int dep);

}
