package com.acolyptos.encoderapp.vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model For Vehicle Inspection Information.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInformation {

  @NotBlank(message = "Historic Vehicle was not provided.")
  @JsonProperty("Historic_Vehicle")
  private String historicVehicle;

  @NotBlank(message = "Equivalent Inertia was not provided.")
  @JsonProperty("Equivalent_Inertia")
  private String equivalentInertia;

  @NotBlank(message = "Fuel Type was not provided.")
  @JsonProperty("Fuel_Type")
  private String fuelType;

  @NotBlank(message = "Traction Type was not provided.")
  @JsonProperty("Traction_Type")
  private String tractionType;

  @NotBlank(message = "Number of Axes was not provided.")
  @JsonProperty("Number_Of_Axes")
  private String numberOfAxes;

  @NotBlank(message = "Model Yeas was not provided.")
  @JsonProperty("Model_Year")
  private String modelYear;

  @NotBlank(message = "Engine Capacity was not provided.")
  @JsonProperty("Engine_Capacity")
  private String engineCapacity;

  @NotBlank(message = "Category was not provided.")
  @JsonProperty("Category")
  private String category;

  @NotBlank(message = "Category Type was not provided.")
  @JsonProperty("Category_Type")
  private String categoryType;

  @NotBlank(message = "Chassis was not provided.")
  @JsonProperty("Chassis")
  private String chassis;

  @NotBlank(message = "Engine was not provided.")
  @JsonProperty("Engine")
  private String engine;

  @NotBlank(message = "MV File Number was not provided.")
  @JsonProperty("MV_File_No")
  private String mvFileNumber;

  @NotBlank(message = "Circulation Date was not provided.")
  @JsonProperty("Circulation_Date")
  private String circulationDate;

  @NotBlank(message = "Color was not provided.")
  @JsonProperty("Color")
  private String color;

  @NotBlank(message = "License Plate was not provided.")
  @JsonProperty("License_Plate")
  private String licensePlate;

  @NotBlank(message = "Manufacturer was not provided.")
  @JsonProperty("Manufacturer")
  private String manufacturer;

  @NotBlank(message = "Brand was not provided.")
  @JsonProperty("Brand")
  private String brand;

  @NotBlank(message = "Mileage was not provided.")
  @JsonProperty("Mileage")
  private String mileage;

  @NotBlank(message = "VIN was not provided.")
  @JsonProperty("VIN")
  private String vin;

  @NotBlank(message = "Turbo was not provided.")
  @JsonProperty("Turbo")
  private String turbo;

  @NotBlank(message = "Presence of Catalytic Converter was not provided.")
  @JsonProperty("Presence_Of_Catalytic_Converter")
  private String presenceOfCatalyticConverter;

  @NotBlank(message = "Maximum Total Weight was not provided.")
  @JsonProperty("Maximum_Total_Weight")
  private String maximumTotalWeight;

  @NotBlank(message = "Date of First Registration was not provided.")
  @JsonProperty("Date_First_Registration")
  private String dateFirstRegistration;

  @Override
  public String toString() {
    return "VehicleInformation: {\n\t\thistoricVehicle: " + historicVehicle
        + ",\n\t\tequivalentInertia: " + equivalentInertia + ",\n\t\tfuelType: " + fuelType
        + ",\n\t\ttractionType: " + tractionType + ",\n\t\tnumberOfAxes: " + numberOfAxes
        + ",\n\t\tmodelYear: " + modelYear + ",\n\t\tengineCapacity: " + engineCapacity
        + ",\n\t\tcategory: " + category + ",\n\t\tcategoryType: " + categoryType
        + ",\n\t\tchassis: " + chassis + ",\n\t\tengine: " + engine + ",\n\t\tmvFileNumber: "
        + mvFileNumber + ",\n\t\tcirculationDate: " + circulationDate + ",\n\t\tcolor: " + color
        + ",\n\t\tlicensePlate: " + licensePlate + ",\n\t\tmanufacturer: " + manufacturer
        + ",\n\t\tbrand: " + brand + ",\n\t\tmileage: " + mileage + ",\n\t\tvin: " + vin
        + ",\n\t\tturbo: " + turbo + ",\n\t\tpresenceOfCatalyticConverter: "
        + presenceOfCatalyticConverter + ",\n\t\tmaximumTotalWeight: " + maximumTotalWeight
        + ",\n\t\tdateFirstRegistration: " + dateFirstRegistration + "\n\t}";
  }


}
