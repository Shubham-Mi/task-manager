package com.example.todolist.service;

import com.example.todolist.dto.CreateUserRequestDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  void createUser(@Valid CreateUserRequestDto request);
}
