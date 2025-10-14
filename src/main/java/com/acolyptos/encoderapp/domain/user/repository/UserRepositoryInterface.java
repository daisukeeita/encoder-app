package com.acolyptos.encoderapp.domain.user.repository;

import com.acolyptos.encoderapp.domain.user.model.User;
import java.util.List;

public interface UserRepositoryInterface {

  User saveUser(User user);

  List<User> getAllUsers();
}
