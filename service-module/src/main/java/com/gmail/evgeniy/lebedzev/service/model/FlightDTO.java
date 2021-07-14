package com.gmail.evgeniy.lebedzev.service.model;

import lombok.Data;

@Data
public class FlightDTO {

    private Long id;
    private String departurePlace;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
}