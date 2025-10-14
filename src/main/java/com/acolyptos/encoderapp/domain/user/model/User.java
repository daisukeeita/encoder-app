package com.acolyptos.encoderapp.domain.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "core")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @NotNull
  @Column(name = "username", nullable = false)
  private String username;

  @NotNull
  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(name = "hashed_password", nullable = false)
  private String hashedPassword;

  @NotNull
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotNull
  @Column(name = "middle_initial", nullable = false)
  private String middleInitial;

  @NotNull
  @Column(name = "last_name", nullable = false)
  private String lastName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", nullable = false)
  private UserRole userRole;

  @NotNull
  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(name = "is_active", nullable = false)
  private boolean isActive;

  @Override
  public String toString() {
    return "User {\n\tuserId: "
        + userId
        + ",\n\tusername: "
        + username
        + ",\n\tfirstName: "
        + firstName
        + ",\n\tmiddleInitial: "
        + middleInitial
        + ",\n\tlastName: "
        + lastName
        + ",\n\tuserRole: "
        + userRole
        + "\n}";
  }
}
