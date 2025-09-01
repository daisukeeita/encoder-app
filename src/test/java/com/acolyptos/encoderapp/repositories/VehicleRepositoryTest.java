// package com.acolyptos.encoderapp.repositories;
//
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import java.util.Optional;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.test.context.TestPropertySource;
// import com.acolyptos.encoderapp.models.Vehicle;
//
// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @TestPropertySource(locations = "classpath:application-test.properties")
// public class VehicleRepositoryTest {
//
//   @Autowired
//   private VehicleRepository vehicleRepository;
//
//   @Test
//   void shouldSaveAndFindVehicleByMake() {
//     Vehicle vehicle = new Vehicle(
//       "AAR4855",
//       "3D7666A51764D251E06373916",
//       "MALA251AAEM257815",
//       "63HADM23257815",
//       "062000000178260",
//       "ELECTRIC RED",
//       "Light Vehicle",
//       "EON",
//       "2014",
//       "Gas"
//     );    
//     
//     vehicleRepository.save(vehicle);
//
//     Optional<Vehicle> found = vehicleRepository.findVehicleByLicensePlate("AAR4855");
//
//     assertTrue(found.isPresent());
//   }
// }
