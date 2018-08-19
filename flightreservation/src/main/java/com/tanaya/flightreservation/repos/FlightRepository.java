package com.tanaya.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanaya.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

}
