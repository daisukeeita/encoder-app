package com.acolyptos.encoderapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acolyptos.encoderapp.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  Optional<Vehicle> findVehicleByMake(String make);
}
