package com.acolyptos.encoderapp.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import com.acolyptos.encoderapp.exceptions.ValidationException;
import com.acolyptos.encoderapp.models.User;
import com.acolyptos.encoderapp.models.UserDTO;
import com.acolyptos.encoderapp.repositories.UserRepository;
import com.acolyptos.encoderapp.services.UserService;

public class UserServiceImplementation implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public User registerUser (UserDTO userDTO) throws ValidationException {
    validateFirstName(userDTO.getFirstName());
    validateLastName(userDTO.getLastName());
    validateUsername(userDTO.getUsername());
    validatePassword(userDTO.getPassword());
    validateEmail(userDTO.getEmail());

    User user = new User(
      userDTO.getFirstName(), 
      userDTO.getLastName(), 
      userDTO.getUsername(), 
      userDTO.getPassword(), 
      userDTO.getEmail()
    );

    return userRepository.save(user);
  }

  
  private void validateFirstName (String firstName) {
    if (firstName == null || firstName.trim().isEmpty()) {
      throw new ValidationException("Username cannot be empty.");
    }
  }
}
