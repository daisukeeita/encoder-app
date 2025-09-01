package com.acolyptos.encoderapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInformation {

  @JsonProperty("Historic_Vehicle")
  private String historicVehicle;

  @JsonProperty("Equivalent_Inertia")
  private String equivalentInertia;

  @JsonProperty("Fuel_Type")
  private String fuelType;

  @JsonProperty("Traction_Type")
  private String tractionType;

  @JsonProperty("Number_Of_Axes")
  private String numberOfAxes;

  @JsonProperty("Model_Year")
  private String modelYear;

  @JsonProperty("Engine_Capacity")
  private String engineCapacity;

  @JsonProperty("Category")
  private String category;

  @JsonProperty("Category_Type")
  private String categoryType;

  @JsonProperty("Chassis")
  private String chassis;

  @JsonProperty("Engine")
  private String engine;

  @JsonProperty("MV_File_No")
  private String mvFileNumber;

  @JsonProperty("Circulation_Date")
  private String circulationDate;

  @JsonProperty("Color")
  private String color;

  @JsonProperty("License_Plate")
  private String licensePlate;

  @JsonProperty("Manufacturer")
  private String manufacturer;

  @JsonProperty("Brand")
  private String brand;

  @JsonProperty("Mileage")
  private String mileage;

  @JsonProperty("VIN")
  private String vin;

  @JsonProperty("Turbo")
  private String turbo;

  @JsonProperty("Presence_Of_Catalytic_Converter")
  private String presenceOfCatalyticConverter;

  @JsonProperty("Maximum_Total_Weight")
  private String maximumTotalWeight;

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
