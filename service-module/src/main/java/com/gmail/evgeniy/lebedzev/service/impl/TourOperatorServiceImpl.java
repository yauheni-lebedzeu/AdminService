package com.gmail.evgeniy.lebedzev.service.impl;

import com.gmail.evgeniy.lebedzev.repository.TourOperatorRepository;
import com.gmail.evgeniy.lebedzev.repository.model.TourOperator;
import com.gmail.evgeniy.lebedzev.service.TourOperatorService;
import com.gmail.evgeniy.lebedzev.service.mapper.TourOperatorMapper;
import com.gmail.evgeniy.lebedzev.service.model.TourOperatorDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TourOperatorServiceImpl implements TourOperatorService {

    private final TourOperatorRepository tourOperatorRepository;
    private final TourOperatorMapper tourOperatorMapper;

    @Override
    @Transactional
    public TourOperatorDTO save(TourOperatorDTO tourOperatorDTO) {
        TourOperator tourOperator = tourOperatorMapper.tourOperatorDTOToTourOperator(tourOperatorDTO);
        TourOperator savedTourOperator = tourOperatorRepository.save(tourOperator);
        return tourOperatorMapper.tourOperatorToTourOperatorDTO(savedTourOperator);
    }

    @Override
    @Transactional
    public List<TourOperatorDTO> findAll() {
        List<TourOperator> operators = tourOperatorRepository.findAll();
        return operators.stream()
                .map(tourOperatorMapper::tourOperatorToTourOperatorDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tourOperatorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TourOperatorDTO update(Long id, TourOperatorDTO tourOperatorDTO) {
        Optional<TourOperator> optionalTourOperator = tourOperatorRepository.findById(id);
        TourOperator tourOperator = optionalTourOperator.get();
        tourOperator.setName(tourOperatorDTO.getName());
        tourOperator.setAddress(tourOperatorDTO.getAddress());
        tourOperatorRepository.save(tourOperator);
        return tourOperatorMapper.tourOperatorToTourOperatorDTO(tourOperator);
    }
}