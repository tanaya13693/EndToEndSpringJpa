package com.tanaya.location.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tanaya.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
