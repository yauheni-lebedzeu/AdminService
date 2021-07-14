package com.gmail.evgeniy.lebedzev.service.mapper;

import com.gmail.evgeniy.lebedzev.repository.model.TourOperator;
import com.gmail.evgeniy.lebedzev.service.model.TourOperatorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TourOperatorMapper {

    TourOperatorDTO tourOperatorToTourOperatorDTO(TourOperator tourOperator);

    TourOperator tourOperatorDTOToTourOperator(TourOperatorDTO tourOperatorDTO);
}
