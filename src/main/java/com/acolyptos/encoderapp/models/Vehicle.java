package com.acolyptos.encoderapp.models;

import java.time.OffsetTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 100)
  private String make;

  @Column(nullable = false, length = 100)
  private String model;

  @Column(nullable = false)
  private Integer year;

  @Column(nullable = false, length = 20, unique = true)
  private String license_plate;

  @Column(unique = true, length = 32)
  private String chassis_number;

  @Column(unique = true, length = 20)
  private String mv_file_number;

  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMPZ DEFAULT NOW()")
  private OffsetTime created_at;

  @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMPZ DEFAULT NOW()")
  private OffsetTime updated_at;
}

