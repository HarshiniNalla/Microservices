package com.example.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Rating {
private String ratingId;
private String hotelId;
private String userId;
private int  rating;
private String feedback;
private  Hotel hotel;



}
