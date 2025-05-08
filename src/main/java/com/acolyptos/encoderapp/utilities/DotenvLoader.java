package com.acolyptos.encoderapp.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {

  public static void load() {
    Dotenv dotenv = Dotenv.configure()
                          .ignoreIfMissing()
                          .load();

    dotenv.entries().forEach(entry ->
      System.setProperty(entry.getKey(), entry.getValue())
    );
  }
}
