package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateUserRequestDto {

  @NotBlank
  private String name;

  @NotBlank
  private String email;

  @NotBlank
  private String password;
}
