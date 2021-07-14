package com.gmail.evgeniy.lebedzev.service;

import com.gmail.evgeniy.lebedzev.service.model.HotelDTO;

import java.util.List;

public interface HotelService {

    HotelDTO save(HotelDTO hotelDTO);

    List<HotelDTO> findAll();

    void deleteById(Long id);

    HotelDTO update(Long id, HotelDTO hotelDTO);
}
