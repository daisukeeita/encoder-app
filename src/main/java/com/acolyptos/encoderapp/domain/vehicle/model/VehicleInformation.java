package com.acolyptos.encoderapp.domain.vehicle.model;

import com.acolyptos.encoderapp.shared.NaJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
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

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Historic_Vehicle")
  private String historicVehicle;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Equivalent_Inertia")
  private String equivalentInertia;

  @NotNull(message = "Fuel Type should not be null.")
  @JsonProperty("Fuel_Type")
  private String fuelType;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Traction_Type")
  private String tractionType;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Number_Of_Axes")
  private String numberOfAxes;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Model_Year")
  private String modelYear;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Engine_Capacity")
  private String engineCapacity;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Category")
  private String category;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Category_Type")
  private String categoryType;

  @NotNull(message = "Chassis should not be null.")
  @JsonProperty("Chassis")
  private String chassis;

  @NotNull(message = "Engine should not be null.")
  @JsonProperty("Engine")
  private String engine;

  @NotNull(message = "MV File Number should not be null.")
  @JsonProperty("MV_File_No")
  private String mvFileNumber;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Circulation_Date")
  private String circulationDate;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Color")
  private String color;

  @NotNull(message = "License Plate should not be null.")
  @JsonProperty("License_Plate")
  private String licensePlate;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Manufacturer")
  private String manufacturer;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Brand")
  private String brand;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Mileage")
  private String mileage;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("VIN")
  private String vin;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Turbo")
  private String turbo;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Presence_Of_Catalytic_Converter")
  private String presenceOfCatalyticConverter;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("Maximum_Total_Weight")
  private String maximumTotalWeight;

  @NotNull(message = "First Registration Date should not be null.")
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
