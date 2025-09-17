package com.acolyptos.encoderapp.domain.vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A class responsible for holding the raw data fetched from the external source. VehicleInformation
 * and VehicleTestLimits are its sub-objects with its own responsibilities.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleInspection {

  @NotNull(message = "Inspection ID should not be null.")
  @JsonProperty("Inspection_ID")
  private String inspectionId;

  @NotNull(message = "Inspection Purpose should not be null.")
  @JsonProperty("Purpose")
  private String purpose;

  @Valid
  @JsonProperty("Vehicle_Information")
  private VehicleInformation vehicleInformation;

  @Valid
  @JsonProperty("Test_Limits")
  private VehicleTestLimits vehicleTestLimits;

  @Override
  public String toString() {
    return "VehicleInspection {\n\tinspectionId: "
        + inspectionId
        + ",\n\tpurpose: "
        + purpose
        + ",\n\t"
        + vehicleInformation
        + ",\n\t"
        + vehicleTestLimits
        + "\n}";
  }
}
