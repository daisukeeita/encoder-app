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
public class VehicleTestLimits {

  @JsonProperty("light_intensity")
  private String lightIntensity;

  @JsonProperty("brake_service_eff")
  private String brakeServiceEff;

  @JsonProperty("brake_parking_eff")
  private String brakeParkingEff;

  @JsonProperty("brake_parking_diff")
  private String brakeServiceDiff;

  @JsonProperty("sideslip_deviation")
  private String sideslipDeviation;

  @JsonProperty("suspension_deviation")
  private String suspensionDeviation;

  @JsonProperty("speed_deviation")
  private String speedDeviation;

  @JsonProperty("sound_level")
  private String soundLevel;

  @JsonProperty("emission_hc")
  private String emissionHc;

  @JsonProperty("emission_co")
  private String emissionCo;

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
