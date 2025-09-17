package com.acolyptos.encoderapp.domain.vehicle.service;

import com.acolyptos.encoderapp.application.vehicle.VehicleAppService;
import com.acolyptos.encoderapp.domain.vehicle.model.Vehicle;
import com.acolyptos.encoderapp.domain.vehicle.model.VehicleInspection;
import org.springframework.stereotype.Service;

/**
 * A service responsible for processing and transforming raw {@link VehicleInspection} data into a
 * structured {@link Vehicle} object.
 *
 * <p>This class is separated from {@link VehicleAppService} to maintain a clear separation of
 * concerns, focusing exclusively on data processing logic.
 */
@Service
public class VehicleService {

  /**
   * Transforms raw vehicle inspection data into a formatted Vehicle object.
   *
   * <p>This method maps fields from {@link VehicleInspection} to {@link Vehicle} and replaces any
   * null values for specific fields (e.g. color, category type, model year) with a descriptive
   * error string.
   *
   * @param vehicleInspection The raw data fetched from external source.
   * @return A {@link Vehicle} object populated with processed and formatted data.
   */
  public Vehicle processVehicleInspectionToVehicle(final VehicleInspection vehicleInspection) {
    final Vehicle vehicle = new Vehicle();
    vehicle.setInspectionId(vehicleInspection.getInspectionId());
    vehicle.setLicensePlate(vehicleInspection.getVehicleInformation().getLicensePlate());
    vehicle.setChassis(vehicleInspection.getVehicleInformation().getChassis());
    vehicle.setEngine(vehicleInspection.getVehicleInformation().getEngine());
    vehicle.setMvFileNumber(vehicleInspection.getVehicleInformation().getMvFileNumber());
    vehicle.setModel(
        vehicleInspection.getVehicleInformation().getManufacturer()
            + " - "
            + vehicleInspection.getVehicleInformation().getBrand());
    vehicle.setFuelType(vehicleInspection.getVehicleInformation().getFuelType());

    if (vehicleInspection.getVehicleInformation().getColor() == null) {
      vehicle.setColor(
          "Color was not provided. Please see the nearest LTO to update the Vehicle Color.");
    } else {
      vehicle.setColor(vehicleInspection.getVehicleInformation().getColor());
    }

    if (vehicleInspection.getVehicleInformation().getCategoryType() == null) {
      vehicle.setCategoryType(
          "Category Type was not provided. Please see the nearest LTO to update the Vehicle"
              + " Category Type.");
    } else {
      vehicle.setCategoryType(vehicleInspection.getVehicleInformation().getCategoryType());
    }

    if (vehicleInspection.getVehicleInformation().getModelYear() == null) {
      vehicle.setModelYear(
          "Year Model was not provided. Please see the nearest LTO to update the Vehicle Year"
              + " Model.");
    } else {
      vehicle.setModelYear(vehicleInspection.getVehicleInformation().getModelYear());
    }
    return vehicle;
  }
}
