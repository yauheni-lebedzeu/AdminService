package com.gmail.evgeniy.lebedzev.repository;

import com.gmail.evgeniy.lebedzev.repository.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
