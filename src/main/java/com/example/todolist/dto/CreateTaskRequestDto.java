package com.example.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CreateTaskRequestDto {

  @NotBlank
  @Size(max = 255, message = "Value may not exceed 255 characters")
  private String title;

  private String description;

  @NotNull
  private TaskStatusDto status;
}
