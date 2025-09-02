package com.acolyptos.encoderapp.vehicle.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
// @Entity
// @Table(name = "vehicle")
public class Vehicle {

  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // private long id;

  // @NonNull
  // @NotBlank(message = "Plate Number is required.")
  // @Column(name = "License_Plate", nullable = false, unique = true, length = 20)
  private String licensePlate;

  // @NonNull
  // @NotBlank(message = "Inspection ID is required.")
  // @Column(name = "Inspection_ID", nullable = false, unique = true, length = 100)
  private String inspectionId;

  // @NonNull
  // @NotBlank(message = "Chassis Number is required.")
  // @Column(name = "Chassis", nullable = false, unique = true, length = 32)
  private String chassis;

  // @NonNull
  // @NotBlank(message = "Engine Number is required.")
  // @Column(name = "Engine", nullable = false, unique = true, length = 20)
  private String engine;

  // @NonNull
  // @NotBlank(message = "MV File Number is required.")
  // @Column(name = "MV_File_Number", nullable = false, unique = true, length = 20)
  private String mvFileNumber;

  // @NonNull
  // @NotBlank(message = "Vehicle Color is required.")
  // @Column(name = "Color", nullable = false, length = 20)
  private String color;

  // @NonNull
  // @NotBlank(message = "Category Type is required.")
  // @Column(name = "Category_Type", nullable = false, length = 20)
  private String categoryType;


  // @NonNull
  // @NotBlank(message = "Vehicle Model is required.")
  // @Column(name = "Model", nullable = false, length = 100)
  private String model;

  // @NonNull
  // @NotBlank(message = "Vehicle Model Year is required.")
  // @Column(name = "Model_Year", nullable = false, length = 5)
  private String modelYear;

  // @NonNull
  // @NotBlank(message = "Fuel Type is required.")
  // @Column(name = "Fuel_Type", nullable = false, length = 7)
  private String fuelType;

  @Override
  public String toString() {
    return "Vehicle {\n\tlicensePlate: " + licensePlate + ",\n\tinspectionId: " + inspectionId
        + ",\n\tchassis: " + chassis + ",\n\tengine: " + engine + ",\n\tmvFileNumber: "
        + mvFileNumber + ",\n\tcolor: " + color + ",\n\tcategoryType: " + categoryType
        + ",\n\tmodel: " + model + ",\n\tmodelYear: " + modelYear + ",\n\tfuelType: " + fuelType
        + "\n}";
  }
}

