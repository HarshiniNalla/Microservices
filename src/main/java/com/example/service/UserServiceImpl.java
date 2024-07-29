package com.example.service;

import com.example.entity.Hotel;
import com.example.entity.Rating;
import com.example.entity.User;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userrepo;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
      String randomUserId=  UUID.randomUUID().toString();
      user.setUserId(randomUserId);
        return userrepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    @Override
    public Optional<User> getUser(String userId) {
//http://localhost:8083/ratings/user/7d05ec21-b54a-4711-9c73-dca9cd9a5635
        User user=userrepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("the user is not present with the id"+userId));
    ArrayList resp=restTemplate.getForObject("http://localhost:8083/ratings/user/"+user.getUserId(), ArrayList.class);
    log.info("{}",resp);
  List<Rating> ratingList= (List<Rating>) resp.stream().map(rating->
    {
      ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://localhost:8082/hotels/f1790bf4-3588-41c1-8c8e-5060790a3f34",Hotel.class);
     Hotel hotel=forEntity.getBody();
     return rating;
    }).collect(Collectors.toList());


    user.setRatings(resp);
        return Optional.ofNullable(user);
    }
}
