package com.acolyptos.encoderapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleInspection {

  @JsonProperty("Inspection_ID")
  private String inspectionId;

  @JsonProperty("Purpose")
  private String purpose;

  @JsonProperty("Vehicle_Information")
  private VehicleInformation vehicleInformation;

  @JsonProperty("Test_Limits")
  private VehicleTestLimits vehicleTestLimits;

  @Override
  public String toString() {
    return "VehicleInspection {\n\tinspectionId: " + inspectionId + ",\n\tpurpose: " + purpose
        + ",\n\t" + vehicleInformation + ",\n\t" + vehicleTestLimits + "\n}";
  }
}
