package com.acolyptos.encoderapp.domain.user.service;

import com.acolyptos.encoderapp.domain.user.model.User;
import com.acolyptos.encoderapp.domain.user.model.UserRegistrationRequest;
import com.acolyptos.encoderapp.domain.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public User processUserDtoToUserEntity(
      final UserRegistrationRequest userRegistrationRequest, final UserRole userRole) {
    final User user = new User();

    user.setUsername(userRegistrationRequest.getUsername());
    user.setHashedPassword(passwordEncoder.encode(userRegistrationRequest.getPlainPassword()));
    user.setFirstName(userRegistrationRequest.getFirstName());
    user.setMiddleInitial(userRegistrationRequest.getMiddleInitial());
    user.setLastName(userRegistrationRequest.getLastName());
    user.setUserRole(userRole);
    user.setActive(true);

    return user;
  }

  public boolean verifyUserPassword(String plainPassword, String hashedPassword) {
    return passwordEncoder.matches(plainPassword, hashedPassword);
  }
}
