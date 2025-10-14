package com.acolyptos.encoderapp.infrastructure.user;

import com.acolyptos.encoderapp.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Long> {

  User findUserByUsername(String username);
}
