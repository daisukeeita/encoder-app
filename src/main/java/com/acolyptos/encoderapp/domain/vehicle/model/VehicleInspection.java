package com.acolyptos.encoderapp.domain.vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model for Vehicle Inspection Information.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleInspection {

  @NotBlank(message = "Inspection ID value was not provided.")
  @NotNull(message = "Inspection ID should not be null.")
  @JsonProperty("Inspection_ID")
  private String inspectionId;

  @NotBlank(message = "Inspection Purpose value was not provided.")
  @NotNull(message = "Inspection Purpose should not be null.")
  @JsonProperty("Purpose")
  private String purpose;
  
  // @NotNull(message = "Vehicle Information should not be null.")
  @Valid
  @JsonProperty("Vehicle_Information")
  private VehicleInformation vehicleInformation;

  // @NotNull(message = "Test Limits should not be null.")
  @Valid
  @JsonProperty("Test_Limits")
  private VehicleTestLimits vehicleTestLimits;

  @Override
  public String toString() {
    return "VehicleInspection {\n\tinspectionId: " + inspectionId + ",\n\tpurpose: " + purpose
        + ",\n\t" + vehicleInformation + ",\n\t" + vehicleTestLimits + "\n}";
  }
}
