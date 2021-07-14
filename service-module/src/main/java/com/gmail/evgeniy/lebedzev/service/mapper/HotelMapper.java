package com.gmail.evgeniy.lebedzev.service.mapper;

import com.gmail.evgeniy.lebedzev.repository.model.Hotel;
import com.gmail.evgeniy.lebedzev.service.model.HotelDTO;
import org.mapstruct.Mapper;

@Mapper
public interface HotelMapper {

    HotelDTO hotelToHotelDTO(Hotel hotel);
    Hotel hotelDTOToHotel(HotelDTO hotel);
}
