package com.tanaya.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanaya.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
