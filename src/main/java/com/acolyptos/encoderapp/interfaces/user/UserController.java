package com.acolyptos.encoderapp.interfaces.user;

import com.acolyptos.encoderapp.application.user.UserAppService;
import com.acolyptos.encoderapp.domain.user.model.User;
import com.acolyptos.encoderapp.domain.user.model.UserLoginRequest;
import com.acolyptos.encoderapp.domain.user.model.UserRegistrationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

  private final UserAppService userAppService;

  public UserController(final UserAppService userAppService) {
    this.userAppService = userAppService;
  }

  @PostMapping(value = "/registerUser")
  public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
    userAppService.processUserDtoAndSaveUser(userRegistrationRequest);
  }

  @PostMapping(value = "/loginUser")
  public User loginUser(@RequestBody UserLoginRequest userLoginRequest) {
    return userAppService.authenticateUser(userLoginRequest);
  }

  @GetMapping(value = "/findUser/{username}")
  public User retrieveUserByUsername(@PathVariable("username") String username) {
    return userAppService.findUserByUsername(username);
  }
}
