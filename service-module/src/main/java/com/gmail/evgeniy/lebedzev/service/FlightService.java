package com.gmail.evgeniy.lebedzev.service;

import com.gmail.evgeniy.lebedzev.service.model.FlightDTO;

import java.util.List;

public interface FlightService {

    FlightDTO save(FlightDTO flightDTO);

    List<FlightDTO> findAll();

    void deleteById(Long id);

    FlightDTO update(Long id, FlightDTO flightDTO);

}
