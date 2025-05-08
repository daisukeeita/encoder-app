package com.acolyptos.encoderapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acolyptos.encoderapp.exceptions.ResourceNotFoundException;
import com.acolyptos.encoderapp.models.User;
import com.acolyptos.encoderapp.repositories.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
         throws ResourceNotFoundException {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new ResourceNotFoundException(
        "User not found for this ID :: " + userId 
    ));

    return ResponseEntity.ok(user);
  }

  @PostMapping("/users")
  public User createUser (@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
         @PathVariable(value = "id") Long userId,
         @Valid @RequestBody User userDetails
  )      throws ResourceNotFoundException {

    User user = userRepository.findById(userId)
      .orElseThrow(() -> new ResourceNotFoundException(
        "User not found for this ID :: " + userId 
    ));

    user.setFirstName(userDetails.getFirstName());
    user.setLastName(userDetails.getLastName());
    user.setEmail(userDetails.getEmail());
    user.setUsername(userDetails.getUsername());

    final User updatedUser = userRepository.save(user);

    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/users/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
         throws ResourceNotFoundException {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new ResourceNotFoundException(
        "User not found for this ID :: " + userId 
    ));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);

    return response;
  }
}
