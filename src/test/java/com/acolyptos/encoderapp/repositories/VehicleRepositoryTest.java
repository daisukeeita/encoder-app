package com.acolyptos.encoderapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import com.acolyptos.encoderapp.models.Vehicle;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VehicleRepositoryTest {

  @Autowired
  private VehicleRepository vehicleRepository;

  @Test
  void shouldSaveAndFindVehicleByMake() {
    Vehicle vehicle = new Vehicle("Toyota", "Vios");
    vehicleRepository.save(vehicle);

    Optional<Vehicle> found = vehicleRepository.findVehicleByMake("Toyota");

    assertTrue(found.isPresent());
    assertEquals(vehicle.getMake(), found.get().getMake());
  }
}
