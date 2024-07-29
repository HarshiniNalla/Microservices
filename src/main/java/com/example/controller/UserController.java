package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
    private UserService userService;
  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user)
  {
      User user1= userService.saveUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(user1);
  }
  @GetMapping("/{userId}")
  public ResponseEntity<Optional<User>> getSingleUserId(@PathVariable String  userId)
  {
      Optional<User> user= userService.getUser(userId);
      return ResponseEntity.ok(user);

  }
  @GetMapping
  public ResponseEntity<List<User>> getAllUsers()
  {
      List<User> user1=userService.getAllUser();
      return ResponseEntity.ok(user1);
  }
}
