package com.acolyptos.encoderapp.application.user;

import com.acolyptos.encoderapp.domain.user.model.User;
import com.acolyptos.encoderapp.domain.user.model.UserLoginRequest;
import com.acolyptos.encoderapp.domain.user.model.UserRegistrationRequest;
import com.acolyptos.encoderapp.domain.user.model.UserRole;
import com.acolyptos.encoderapp.domain.user.service.UserService;
import com.acolyptos.encoderapp.infrastructure.user.UserRepositoryImpl;
import com.acolyptos.encoderapp.infrastructure.user.UserRoleRepositoryImpl;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {

  private final Validator validator;
  private final UserService userService;
  private final UserRepositoryImpl userRepositoryImpl;
  private final UserRoleRepositoryImpl userRoleRepositoryImpl;

  @Autowired
  public UserAppService(
      Validator validator,
      UserService userService,
      UserRepositoryImpl userRepositoryImpl,
      UserRoleRepositoryImpl userRoleRepositoryImpl) {
    this.validator = validator;
    this.userService = userService;
    this.userRepositoryImpl = userRepositoryImpl;
    this.userRoleRepositoryImpl = userRoleRepositoryImpl;
  }

  public void processUserDtoAndSaveUser(final UserRegistrationRequest userRegistrationRequest) {
    final Set<ConstraintViolation<UserRegistrationRequest>> violations =
        validator.validate(userRegistrationRequest);

    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    UserRole userRole = retrieveUserRoleById(userRegistrationRequest.getRoleId());
    User user = userService.processUserDtoToUserEntity(userRegistrationRequest, userRole);

    userRepositoryImpl.save(user);
  }

  public User authenticateUser(final UserLoginRequest userLoginRequest) {
    final Set<ConstraintViolation<UserLoginRequest>> violations =
        validator.validate(userLoginRequest);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    User requestedUser = userRepositoryImpl.findUserByUsername(userLoginRequest.getUsername());
    boolean verifiedPassword =
        userService.verifyUserPassword(
            userLoginRequest.getPlainPassword(), requestedUser.getHashedPassword());

    if (!verifiedPassword) {
      System.out.println("Password doesn't match.");
    }

    return requestedUser;
  }

  public User findUserByUsername(final String username) {
    User user = userRepositoryImpl.findUserByUsername(username);
    return user;
  }

  private UserRole retrieveUserRoleById(Long roleId) {
    return userRoleRepositoryImpl.getReferenceById(roleId);
  }
}
