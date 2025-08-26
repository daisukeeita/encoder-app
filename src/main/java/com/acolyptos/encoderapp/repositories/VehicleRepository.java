package com.acolyptos.encoderapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.acolyptos.encoderapp.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  List<Vehicle> findByMake(String make);
}
