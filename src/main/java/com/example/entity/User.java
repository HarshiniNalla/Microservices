package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity(name="projuser")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String  userId;
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
