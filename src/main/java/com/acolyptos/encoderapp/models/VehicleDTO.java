package com.acolyptos.encoderapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class VehicleDTO {

  
  private String licensePlate;
  private String mvFileNumber;
  private String engine;
  private String chassis;
  private String fuelType;
  private String manufacturer;
  private String model;
  private String modelYear;
  private String color;

  @Override
  public String toString() {
    return "VehicleDTO {\n\tlicensePlate: " + licensePlate + ",\n\tmvFileNumber: " + mvFileNumber
        + ",\n\tengine: " + engine + ",\n\tchassis: " + chassis + ",\n\tfuelType: " + fuelType
        + ",\n\tmanufacturer: " + manufacturer + ",\n\tmodel: " + model + ",\n\tmodelYear: "
        + modelYear + ",\n\tcolor: " + color + "\n}";
  }
}
