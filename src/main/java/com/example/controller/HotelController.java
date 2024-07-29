package com.example.controller;

import com.example.entity.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @PostMapping
    public Hotel saveHotel(@RequestBody Hotel hotel)
    {
        return hotelService.create(hotel);
    }
    @GetMapping
    public List<Hotel>  getAllHotels()
    {
        return hotelService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getByIds(@PathVariable String id)
    {

        return  hotelService.getById(id);
    }



}
