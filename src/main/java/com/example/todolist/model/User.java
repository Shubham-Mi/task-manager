package com.example.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "user", schema = "todo")
public class User extends BaseEntity {

  @NotBlank(message = "Value may not be blank")
  @Column(name = "name", nullable = false)
  private String name;

  @Email(message = "Email is not correct")
  @NotBlank(message = "Value may not be blank")
  @Size(max = 255, message = "Value may not exceed 255 characters")
  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @NotBlank(message = "Value may not be blank")
  @Size(max = 255, message = "Value may not exceed 255 characters")
  @Column(name = "password", nullable = false)
  private String password;

  @NotNull
  @Enumerated(value = EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;
}
