package com.example.service;

import com.example.entity.Rating;
import com.example.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

  @Autowired
  private RatingRepository ratingrepo;
    @Override
    public Rating create(Rating rating) {
        String randomUserId=  UUID.randomUUID().toString();
        rating.setRatingId(randomUserId);
        return ratingrepo.save(rating);
    }

    @Override
    public List<Rating> findAll() {
        return ratingrepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingrepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingrepo.findByHotelId(hotelId);
    }


    @Override
    public Optional<Rating> findById(String ratingId) {
        return ratingrepo.findById(ratingId);
    }

}
