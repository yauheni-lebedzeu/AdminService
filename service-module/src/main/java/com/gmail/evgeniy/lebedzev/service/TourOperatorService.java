package com.gmail.evgeniy.lebedzev.service;

import com.gmail.evgeniy.lebedzev.service.model.TourOperatorDTO;

import java.util.List;

public interface TourOperatorService {

    TourOperatorDTO save(TourOperatorDTO tourOperator);

    List<TourOperatorDTO> findAll();

    void deleteById(Long id);

    TourOperatorDTO update(Long id, TourOperatorDTO tourOperatorDTO);

}
