package com.acolyptos.encoderapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class App {
  private final static Dotenv DOTENV = Dotenv.load();
  private final static String URL = DOTENV.get("DATABASE_URL");
  private final static String USER = DOTENV.get("DATABASE_USER");
  private final static String PASSWORD = DOTENV.get("DATABASE_PASSWORD"); 

  private static Connection connection;

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Connected to PostgreSQL successfully.");

    } catch (SQLException exception) {
      System.out.println("Connection failed. " + exception.getMessage());
      exception.printStackTrace();
    } catch (ClassNotFoundException exception) {
      System.out.println("PostgreSQL Driver not found.");
      exception.printStackTrace();
    } finally {
      connection.close();
    }
  }
}
