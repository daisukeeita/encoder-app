package com.acolyptos.encoderapp.domain.vehicle.model;

import com.acolyptos.encoderapp.shared.NaJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("light_intensity")
  private String lightIntensity;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("brake_service_eff")
  private String brakeServiceEff;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("brake_parking_eff")
  private String brakeParkingEff;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("brake_parking_diff")
  private String brakeServiceDiff;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("sideslip_deviation")
  private String sideslipDeviation;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("suspension_deviation")
  private String suspensionDeviation;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("speed_deviation")
  private String speedDeviation;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("sound_level")
  private String soundLevel;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("emission_hc")
  private String emissionHc;

  @JsonDeserialize(using = NaJsonDeserializer.class)
  @JsonProperty("emission_co")
  private String emissionCo;

  @JsonDeserialize(using = NaJsonDeserializer.class)
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
