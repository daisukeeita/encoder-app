package com.acolyptos.encoderapp.services;

import java.util.List;
import com.acolyptos.encoderapp.exceptions.EntityNotFoundException;
import com.acolyptos.encoderapp.exceptions.ValidationException;
import com.acolyptos.encoderapp.models.User;
import com.acolyptos.encoderapp.models.UserDTO;

public interface UserService {
  User registerUser (UserDTO userDTO) throws ValidationException;
  User updateUser (UserDTO userDTO) throws ValidationException;
  boolean deleteUser (Long userId, UserDTO userDTO) throws EntityNotFoundException;
  User getUserById (Long userId) throws EntityNotFoundException;
  List<User> getAllUsers ();
}
