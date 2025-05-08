package com.acolyptos.encoderapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  public User() {}

  public User(
    String firstName,
    String lastName,
    String username,
    String password,
    String email
  ) {
    this.firstName = firstName;
    this.lastName =  lastName;
    this.username =  username;
    this.password =  password;
    this.email =     email;
  }

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }

  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  @Override
  public String toString() {
    return "User{id=" + id + 
           ", firstName=" + firstName + 
           ", lastName=" + lastName + 
           ", username=" + username + 
           ", email=" + email + 
           "}";
  }
}
