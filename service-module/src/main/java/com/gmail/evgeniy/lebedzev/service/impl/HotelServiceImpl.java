package com.gmail.evgeniy.lebedzev.service.impl;

import com.gmail.evgeniy.lebedzev.repository.HotelRepository;
import com.gmail.evgeniy.lebedzev.repository.model.Hotel;
import com.gmail.evgeniy.lebedzev.service.HotelService;
import com.gmail.evgeniy.lebedzev.service.mapper.HotelMapper;
import com.gmail.evgeniy.lebedzev.service.model.HotelDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    @Transactional
    public HotelDTO save(HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.hotelDTOToHotel(hotelDTO);
        Hotel savedHotel = hotelRepository.save(hotel);
        return hotelMapper.hotelToHotelDTO(savedHotel);
    }

    @Override
    @Transactional
    public List<HotelDTO> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotelMapper::hotelToHotelDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public HotelDTO update(Long id, HotelDTO hotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        Hotel hotel = optionalHotel.get();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotelRepository.save(hotel);
        return hotelMapper.hotelToHotelDTO(hotel);
    }
}