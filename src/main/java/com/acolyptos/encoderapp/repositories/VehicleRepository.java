package com.acolyptos.encoderapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acolyptos.encoderapp.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  Optional<Vehicle> findVehicleByPlateNumber(String plateNumber);
  Optional<Vehicle> findVehicleByChassisNumber(String chassisNumber);
  Optional<Vehicle> findVehicleByMvFileNumber(String mvFileNumber);
}
