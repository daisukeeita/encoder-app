package com.acolyptos.encoderapp.shared;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NaJsonDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    String value = parser.getValueAsString();
    if (value == null || "NA".equalsIgnoreCase(value)) {
      return null;
    }

    return value;
  }
}
