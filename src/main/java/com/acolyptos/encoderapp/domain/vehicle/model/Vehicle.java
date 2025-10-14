package com.acolyptos.encoderapp.domain.vehicle.model;

import com.acolyptos.encoderapp.shared.NaJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * An class responsible for holding the transformed data from {@link VehicleInspection}. It uses
 * custom JSON Deserializer {@link NaJsonDeserializer} to replace "NA" or NULL into a null value.
 */
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String inspectionId;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String licensePlate;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String chassis;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String engine;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String mvFileNumber;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String color;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String categoryType;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String manufacturer;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String brand;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String modelYear;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String fuelType;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  private String maximumTotalWeight;

  @Override
  public String toString() {
    return "Vehicle {\n\tlicensePlate: "
        + licensePlate
        + ",\n\tinspectionId: "
        + inspectionId
        + ",\n\tchassis: "
        + chassis
        + ",\n\tengine: "
        + engine
        + ",\n\tmvFileNumber: "
        + mvFileNumber
        + ",\n\tcolor: "
        + color
        + ",\n\tcategoryType: "
        + categoryType
        + ",\n\tmanufacturer: "
        + manufacturer
        + ",\n\tbrand: "
        + brand
        + ",\n\tmodelYear: "
        + modelYear
        + ",\n\tfuelType: "
        + fuelType
        + ",\n\tmaximumTotalWeight: "
        + maximumTotalWeight
        + "\n}";
  }
}
