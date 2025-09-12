package com.acolyptos.encoderapp.application.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleRequest;
import com.acolyptos.encoderapp.domain.vehicle.repository.VehicleClientInterface;
import com.acolyptos.encoderapp.domain.vehicle.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Validator;

@ExtendWith(MockitoExtension.class)
public class VehicleAppServiceTest {

  @Mock
  private Validator validator;

  @Mock
  private VehicleClientInterface vehicleClientInterface;

  @Mock
  private VehicleService vehicleService;

  @InjectMocks
  private VehicleAppService vehicleAppService;

  private VehicleRequest request;

  @BeforeEach
  void init() {
    request = new VehicleRequest("", "", "", "UQQ188", "");
  }


  @Test
  void shouldReturnVehicleWhenDataIsValid() throws Exception {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    VehicleInspection vehicleInspection = mapper
        .readValue(new File("src/test/resources/mock/vehicle-test.json"), VehicleInspection.class);

    Vehicle expectedVehicle = new Vehicle();
    expectedVehicle.setLicensePlate("AAR4855");

    when(vehicleClientInterface.fetchVehicleData(request)).thenReturn(vehicleInspection);
    when(vehicleService.processVehicleInspectionToVehicle(vehicleInspection))
        .thenReturn(expectedVehicle);
    when(validator.validate(vehicleInspection)).thenReturn(Collections.emptySet());

    // Act
    Vehicle actualVehicle = vehicleAppService.filterVehicleInspectionFromJson(request);

    // Assert
    assertNotNull(actualVehicle);
    assertEquals("AAR4855", actualVehicle.getLicensePlate());

    verify(vehicleClientInterface, times(1)).fetchVehicleData(request);
    verify(vehicleService, times(1)).processVehicleInspectionToVehicle(vehicleInspection);
  }
}
