package com.gmail.evgeniy.lebedzev.service.mapper;

import com.gmail.evgeniy.lebedzev.repository.model.Flight;
import com.gmail.evgeniy.lebedzev.service.model.FlightDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    FlightDTO flightToFlightDTO(Flight flight);

    Flight flightDTOToFlight(FlightDTO flightDTO);
}
