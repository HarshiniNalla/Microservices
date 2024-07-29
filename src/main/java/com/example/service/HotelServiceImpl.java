package com.example.service;

import com.example.entity.Hotel;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements  HotelService {

    @Autowired
    HotelRepository hotelrepo;
    @Override
    public Hotel create(Hotel hotel) {
        String randomUserId=  UUID.randomUUID().toString();
        hotel.setId(randomUserId);
        return hotelrepo.save(hotel);


    }

    @Override
    public List<Hotel> getAll() {
        return hotelrepo.findAll();
    }

    @Override
    public Optional<Hotel> getById(String id) {
        return Optional.ofNullable(hotelrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id id not found!!")));
    }
}
