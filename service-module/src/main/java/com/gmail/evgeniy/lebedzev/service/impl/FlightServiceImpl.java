package com.gmail.evgeniy.lebedzev.service.impl;

import com.gmail.evgeniy.lebedzev.repository.FlightRepository;
import com.gmail.evgeniy.lebedzev.repository.model.Flight;
import com.gmail.evgeniy.lebedzev.service.FlightService;
import com.gmail.evgeniy.lebedzev.service.mapper.FlightMapper;
import com.gmail.evgeniy.lebedzev.service.model.FlightDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    @Transactional
    public FlightDTO save(FlightDTO flightDTO) {
        Flight flight = flightMapper.flightDTOToFlight(flightDTO);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.flightToFlightDTO(savedFlight);
    }

    @Override
    @Transactional
    public List<FlightDTO> findAll() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
                .map(flightMapper::flightToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    @Transactional
    public FlightDTO update(Long id, FlightDTO flightDTO) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        Flight flight = optionalFlight.get();
        flight.setDeparturePlace(flightDTO.getDeparturePlace());
        flight.setDestination(flightDTO.getDestination());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalDate(flightDTO.getArrivalDate());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flightRepository.save(flight);
        return flightMapper.flightToFlightDTO(flight);
    }
}