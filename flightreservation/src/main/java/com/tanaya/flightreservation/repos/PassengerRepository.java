package com.tanaya.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanaya.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
