package com.example.controller;

import com.example.entity.Rating;
import com.example.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

@PostMapping
public Rating create(@RequestBody Rating rating)
{
    return ratingService.create(rating);
}
@GetMapping("/{ratingId}")
    public Optional<Rating> findByRatingId(@PathVariable String ratingId)
{
    return ratingService.findById(ratingId);
}
@GetMapping("/user/{userId}")
    public List<Rating> findByUserId(@PathVariable String userId)
{
    return ratingService.getRatingByUserId(userId);
}
@GetMapping("/hotels/{hotelId}")
    public List<Rating> findByHotelId( @PathVariable  String hotelId)
{
    return ratingService.getRatingByHotelId(hotelId);
}
@GetMapping
    public  List<Rating> findAll()
{
    return ratingService.findAll();
}
}
