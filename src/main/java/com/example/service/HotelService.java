package com.example.service;

import com.example.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Optional<Hotel> getById(String id);



}
