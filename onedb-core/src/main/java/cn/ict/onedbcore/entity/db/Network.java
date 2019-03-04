package cn.ict.onedbcore.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.LongArrayType;

import lombok.Data;

@Data
@Entity
@Table(name = "objectnetwork")
@TypeDefs({
    @TypeDef(
        name = "long-array", 
        typeClass = LongArrayType.class
    )
})
public class Network {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	@Type(type = "long-array")
	@Column(
		name = "nodes",
		columnDefinition = "bigint[]"
	)
	private long[] nodes;
	
	//public void NetworkFromWrapper(NetWork4Json netWork4Json) {
	//	if (null != netWork4Json) {
	//		this.nodes = netWork4Json.getNodeIdList();
	//	}
	//}


}
