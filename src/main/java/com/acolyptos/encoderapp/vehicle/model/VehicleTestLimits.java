package com.acolyptos.encoderapp.vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class VehicleTestLimits {

  @NotBlank(message = "Light Instensity value was not provided.")
  @NotNull(message = "Light Intensity should not be null.")
  @JsonProperty("light_intensity")
  private String lightIntensity;

  @NotBlank(message = "Brake Service Efficiency value was not provided.")
  @NotNull(message = "Brake Service Efficiency should not be null.")
  @JsonProperty("brake_service_eff")
  private String brakeServiceEff;

  @NotBlank(message = "Brake Parking Efficiency value was not provided.")
  @NotNull(message = "Brake Parking Efficiency should not be null.")
  @JsonProperty("brake_parking_eff")
  private String brakeParkingEff;

  @NotBlank(message = "Brake Parking Difference value was not provided.")
  @NotNull(message = "Brake Parking Difference value should not be null.")
  @JsonProperty("brake_parking_diff")
  private String brakeServiceDiff;

  @NotBlank(message = "Sideslip Deviation value was not provided.")
  @NotNull(message = "Sideslip Deviation should not be null.")
  @JsonProperty("sideslip_deviation")
  private String sideslipDeviation;

  @NotBlank(message = "Suspension Deviation value was not provided.")
  @NotNull(message = "Suspension Deviation value should not be null.")
  @JsonProperty("suspension_deviation")
  private String suspensionDeviation;

  @NotBlank(message = "Speed Deviation value was not provided.")
  @NotNull(message = "Speed Deviation should not be null.")
  @JsonProperty("speed_deviation")
  private String speedDeviation;

  @NotBlank(message = "Sound Level value was not provided.")
  @NotNull(message = "Sound Level should not be null.")
  @JsonProperty("sound_level")
  private String soundLevel;

  @NotBlank(message = "Emission Hydrocarbon value was not provided.")
  @NotNull(message = "Emissions Hydrocarbon should not be null.")
  @JsonProperty("emission_hc")
  private String emissionHc;

  @NotBlank(message = "Emission Carbon Monoxide value was not provided.")
  @NotNull(message = "Emissions Carbon Monoxide should not be null.")
  @JsonProperty("emission_co")
  private String emissionCo;

  @NotBlank(message = "Smoke Opacity value was not provided.")
  @NotNull(message = "Smoke Opacity should not be null.")
  @JsonProperty("opacity_k")
  private String opacityK;

  @Override
  public String toString() {
    return "VehicleTestLimits: {\n\t\tlightIntensity: " + lightIntensity
        + ",\n\t\tbrakeServiceEff: " + brakeServiceEff + ",\n\t\tbrakeParkingEff: "
        + brakeParkingEff + ",\n\t\tbrakeServiceDiff: " + brakeServiceDiff
        + ",\n\t\tsideslipDeviation: " + sideslipDeviation + ",\n\t\tsuspensionDeviation: "
        + suspensionDeviation + ",\n\t\tspeedDeviation: " + speedDeviation + ",\n\t\tsoundLevel: "
        + soundLevel + ",\n\t\temissionHc: " + emissionHc + ",\n\t\temissionCo: " + emissionCo
        + ",\n\t\topacityK: " + opacityK + "\n\t}";
  }


}
