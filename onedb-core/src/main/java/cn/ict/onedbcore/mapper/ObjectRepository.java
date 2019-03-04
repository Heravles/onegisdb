package cn.ict.onedbcore.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.ict.onedbcore.entity.db.Object;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Long>{
	
}
