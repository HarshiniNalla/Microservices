package com.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projratings")
public class Rating {
    @Id
    public String ratingId;
    public String hotelId;
    public String userId;
    public String feedback;
    public int rating;
    public  Hotel hotel;


}
