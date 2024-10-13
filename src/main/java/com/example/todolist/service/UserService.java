package com.example.todolist.service;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.dto.CreateUserResponseDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  CreateUserResponseDto createUser(@Valid CreateUserRequestDto request);
}
