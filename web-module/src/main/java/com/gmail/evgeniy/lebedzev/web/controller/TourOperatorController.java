package com.gmail.evgeniy.lebedzev.web.controller;

import com.gmail.evgeniy.lebedzev.service.TourOperatorService;
import com.gmail.evgeniy.lebedzev.service.model.TourOperatorDTO;
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
@RequestMapping(value = "/operators")
@AllArgsConstructor
public class TourOperatorController {

    private final TourOperatorService tourOperatorService;

    @PostMapping
    public ResponseEntity<?> addOperator(@RequestBody TourOperatorDTO tourOperator) {
        System.out.println(tourOperator);
        tourOperatorService.save(tourOperator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOperator(@PathVariable Long id) {
        tourOperatorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    private List<TourOperatorDTO> getOperators() {
        return tourOperatorService.findAll();
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<?> updateOperator(@RequestBody TourOperatorDTO tourOperator,
                                             @PathVariable Long id) {
        tourOperatorService.update(id, tourOperator);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
