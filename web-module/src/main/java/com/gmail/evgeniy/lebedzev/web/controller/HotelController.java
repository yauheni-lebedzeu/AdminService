package com.gmail.evgeniy.lebedzev.web.controller;

import com.gmail.evgeniy.lebedzev.service.HotelService;
import com.gmail.evgeniy.lebedzev.service.model.HotelDTO;
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
@RequestMapping(value = "/hotels")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<?> addHotel(@RequestBody HotelDTO hotel) {
        hotelService.save(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<HotelDTO> getHotels() {
        return hotelService.findAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateHotel(@RequestBody HotelDTO hotel,
                                         @PathVariable Long id) {
        hotelService.update(id, hotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}