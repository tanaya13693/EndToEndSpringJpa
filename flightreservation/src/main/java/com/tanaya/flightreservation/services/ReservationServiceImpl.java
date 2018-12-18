package com.tanaya.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tanaya.flightreservation.dto.ReservationRequest;
import com.tanaya.flightreservation.entities.Flight;
import com.tanaya.flightreservation.entities.Passenger;
import com.tanaya.flightreservation.entities.Reservation;
import com.tanaya.flightreservation.repos.FlightRepository;
import com.tanaya.flightreservation.repos.PassengerRepository;
import com.tanaya.flightreservation.repos.ReservationRepository;
import com.tanaya.flightreservation.util.EmailUtil;
import com.tanaya.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Value("${com.tanaya.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
	
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
			
		//Make payment
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();	
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}
	
}
