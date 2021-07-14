package com.gmail.evgeniy.lebedzev.repository;

import com.gmail.evgeniy.lebedzev.repository.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findByArrivalDate(LocalDate arrivalDate);

    Flight findByDepartureDate(LocalDate departureDate);

    Flight findByDestination(String destination);

    Flight findByDeparturePlace(String departurePlace);
}
