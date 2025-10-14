package com.acolyptos.encoderapp.infrastructure.user;

import com.acolyptos.encoderapp.domain.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepositoryImpl extends JpaRepository<UserRole, Long> {

  UserRole getReferenceById(Long roleId);
}
