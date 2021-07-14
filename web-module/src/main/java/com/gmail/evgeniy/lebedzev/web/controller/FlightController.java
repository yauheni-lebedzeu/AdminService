package com.gmail.evgeniy.lebedzev.web.controller;

import com.gmail.evgeniy.lebedzev.service.FlightService;
import com.gmail.evgeniy.lebedzev.service.model.FlightDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/flights")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<?> addFlight(@RequestBody FlightDTO flightDTO) {
        flightService.save(flightDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        flightService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<FlightDTO> getFlights() {
        return flightService.findAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateFlight(@RequestBody FlightDTO flight,
                                          @PathVariable Long id) {
        flightService.update(id, flight);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}