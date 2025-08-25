package com.acolyptos.encoderapp.models;

import java.time.OffsetTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @NonNull
  @Column(nullable = false, length = 100)
  private String make;

  @NonNull
  @Column(nullable = false, length = 100)
  private String model;

  @NonNull
  @Column(nullable = false)
  private Integer year;

  @NonNull
  @Column(nullable = false, length = 20, unique = true)
  private String license_plate;

  @Column(unique = true, length = 32)
  private String chassis_number;

  @Column(unique = true, length = 20)
  private String mv_file_number;

  // TODO: Update the time and date 
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMPZ DEFAULT NOW()")
  private OffsetTime created_at;

  @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMPZ DEFAULT NOW()")
  @CreationTimestamp
  private OffsetTime updated_at;


  @PrePersist
  protected void onCreate() {
    this.created_at = OffsetTime.now();
    this.updated_at = OffsetTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = OffsetTime.now();
  }
}

