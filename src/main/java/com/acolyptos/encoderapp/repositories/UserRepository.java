package com.acolyptos.encoderapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acolyptos.encoderapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
