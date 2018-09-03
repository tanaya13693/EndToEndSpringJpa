package com.tanaya.flightcheckin.integration;

import com.tanaya.flightcheckin.integration.dto.Reservation;
import com.tanaya.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);
}
