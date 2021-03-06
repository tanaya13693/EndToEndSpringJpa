package com.tanaya.location.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanaya.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query("select type,count(type) from Location group by type")	//Spring data JPA query	aka JPA query/hql query/jpql
	public List<Object[]> findTypeAndTypeCount();
	
	
}
