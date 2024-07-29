package com.example.service;

import com.example.entity.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    Rating create(Rating rating);
    List<Rating> findAll();
  List<Rating> getRatingByUserId(String userId);
  List<Rating> getRatingByHotelId(String hotelId);
    Optional<Rating> findById(String ratingId);
}
