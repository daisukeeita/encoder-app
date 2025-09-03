package com.acolyptos.encoderapp.vehicle.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import com.acolyptos.encoderapp.vehicle.exception.VehicleDataParseException;
import com.acolyptos.encoderapp.vehicle.model.VehicleInspection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class VehicleFileRepository {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final ClassPathResource resource = new ClassPathResource("mock/vehicle.json");

  /**
   * Fetches and return a vehicle information or throws an error if there's no data.
   *
   * @return VehicleInspection object once the data is fetched.
   *
   * @throws IOException if it the file is empty or the data is missing.
   */
  public VehicleInspection fetchVehicleData() throws IOException {
    try (InputStream file = resource.getInputStream()) {
      final VehicleInspection vehicleInspectionData =
          objectMapper.readValue(file, VehicleInspection.class);

      return vehicleInspectionData;
    } catch (final FileNotFoundException exception) {
      throw new VehicleDataParseException("Vehicle data file not found: ", exception);
    } catch (final JsonProcessingException exception) {
      throw new VehicleDataParseException("Invalid vehicle data file: ", exception);
    } catch (final IOException exception) {
      throw new VehicleDataParseException("I/O error while reading vehicle data: ", exception);
    }

  }
}
