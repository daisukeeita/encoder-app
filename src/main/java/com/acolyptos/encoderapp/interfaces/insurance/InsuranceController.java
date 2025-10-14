package com.acolyptos.encoderapp.interfaces.insurance;

import com.acolyptos.encoderapp.domain.insurance.InsurancePolicy;
import com.acolyptos.encoderapp.domain.insurance.InsuranceRequest;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/insurance")
public class InsuranceController {
  private static final Logger clientLog = LoggerFactory.getLogger("client.requests");
  private static final Logger serverLog = LoggerFactory.getLogger(InsuranceController.class);

  // TODO: Connect this to a Insurer's API Link in a service layer
  @PostMapping(value = "/requestInsurancePolicyNumber")
  public InsurancePolicy requestInsurancePolicyNumber(
      @RequestBody InsuranceRequest insuranceRequest) {
    serverLog.info("Client requesting for Insurance Policy. Processing the request to Insurer.");

    final InsurancePolicy insurancePolicy =
        new InsurancePolicy("SAMPLE-001-POLNO", "AAR4855", "John Doe");

    serverLog.info("Successfully processed the Insurance Policy Number for AAR4855");

    return insurancePolicy;
  }

  @PostMapping(value = "/clientLog")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void receivedClientLog(@RequestBody Map<String, Object> clientPayload) {
    String level = (String) clientPayload.getOrDefault("level", "INFO");
    String message = (String) clientPayload.getOrDefault("message", "Client Log Received.");

    clientPayload.forEach((key, value) -> MDC.put(key, String.valueOf(value)));

    try {
      switch (level.toUpperCase()) {
        case "ERROR":
          clientLog.error("Client Error: {}", message);
          break;
        case "WARN":
          clientLog.warn("Client Warning: {}", message);
          break;
        case "INFO":
        default:
          clientLog.info("Client Info: {}", message);
          break;
      }
    } finally {
      MDC.clear();
    }
  }
}
