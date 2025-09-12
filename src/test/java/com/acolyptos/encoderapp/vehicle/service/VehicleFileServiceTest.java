

// package com.acolyptos.encoderapp.vehicle.service;
//
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
// import java.io.IOException;
// import java.util.Collections;
// import java.util.Set;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleDataValidationException;
// import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleFileHandlingException;
// import com.acolyptos.encoderapp.domain.vehicle.exception.VehicleMissingDataException;
// import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
// import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInformation;
// import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
// import com.acolyptos.encoderapp.vehicle.repository.VehicleFileRepository;
// import jakarta.validation.ConstraintViolation;
// import jakarta.validation.ConstraintViolationException;
// import jakarta.validation.Validator;
//
// class VehicleFileServiceTest {
//
//   @Mock
//   private VehicleFileRepository vehicleFileRepository;
//
//   @Mock
//   private Validator validator;
//
//   private VehicleAppService vehicleAppService;
//
//   @BeforeEach
//   void setUp() {
//     MockitoAnnotations.openMocks(this);
//     vehicleFileService = new VehicleFileService(vehicleFileRepository, validator);
//   }
//
//   @Test
//   void shouldReturnVehicleWhenDataIsValid() throws Exception {
//     // Arrange
//     VehicleInspection inspection = buildValidInspection();
//     when(vehicleFileRepository.fetchVehicleData()).thenReturn(inspection);
//     when(validator.validate(inspection)).thenReturn(Collections.emptySet());
//
//     // Act
//     Vehicle vehicle = vehicleFileService.setFilterVehicleInformationFromJson();
//
//     // Assert
//     assertNotNull(vehicle);
//     assertEquals("ABC123", vehicle.getLicensePlate());
//     assertEquals("Toyota - Corolla", vehicle.getModel());
//     verify(vehicleFileRepository, times(1)).fetchVehicleData();
//   }
//
//   @Test
//   void shouldThrowValidationExceptionWhenConstraintViolation() throws Exception {
//     // Arrange
//     VehicleInspection inspection = buildValidInspection();
//     when(vehicleFileRepository.fetchVehicleData()).thenReturn(inspection);
//
//     @SuppressWarnings("unchecked")
//     ConstraintViolation<VehicleInspection> violation = mock(ConstraintViolation.class);
//     when(validator.validate(inspection)).thenReturn(Set.of(violation));
//
//     // Act + Assert
//     assertThrows(ConstraintViolationException.class, () -> {
//       vehicleFileService.setFilterVehicleInformationFromJson();
//     });
//   }
//
//   @Test
//   void shouldWrapVehicleMissingDataException() throws Exception {
//     when(vehicleFileRepository.fetchVehicleData())
//         .thenThrow(new VehicleMissingDataException("Missing chassis"));
//
//     VehicleDataValidationException ex = assertThrows(VehicleDataValidationException.class, () -> {
//       vehicleFileService.setFilterVehicleInformationFromJson();
//     });
//
//     assertTrue(ex.getMessage().contains("validating the data"));
//   }
//
//   @Test
//   void shouldWrapVehicleFileHandlingException() throws Exception {
//     when(vehicleFileRepository.fetchVehicleData())
//         .thenThrow(new VehicleFileHandlingException("Corrupted file"));
//
//     VehicleDataValidationException ex = assertThrows(VehicleDataValidationException.class, () -> {
//       vehicleFileService.setFilterVehicleInformationFromJson();
//     });
//
//     assertTrue(ex.getMessage().contains("handling vehicle file data"));
//   }
//
//   @Test
//   void shouldWrapException() throws Exception {
//     when(vehicleFileRepository.fetchVehicleData()).thenThrow(new IOException("Disk error"));
//
//     VehicleDataValidationException ex = assertThrows(VehicleDataValidationException.class, () -> {
//       vehicleFileService.setFilterVehicleInformationFromJson();
//     });
//
//     assertTrue(ex.getMessage().contains("Unexpected I/O error"));
//   }
//
//   // Helper to build a valid inspection object
//   private VehicleInspection buildValidInspection() {
//     VehicleInspection inspection = new VehicleInspection();
//     inspection.setInspectionId("123");
//
//     VehicleInformation info = new VehicleInformation();
//     info.setLicensePlate("ABC123");
//     info.setChassis("CHS456");
//     info.setEngine("ENG789");
//     info.setMvFileNumber("MV001");
//     info.setColor("Red");
//     info.setCategory("Sedan");
//     info.setManufacturer("Toyota");
//     info.setBrand("Corolla");
//     info.setModelYear("2021");
//     info.setFuelType("Gasoline");
//
//     inspection.setVehicleInformation(info);
//
//     return inspection;
//   }
// }

