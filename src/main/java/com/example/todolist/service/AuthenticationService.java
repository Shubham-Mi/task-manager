package com.example.todolist.service;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.dto.UserSignInRequestDto;
import jakarta.validation.Valid;

public interface AuthenticationService {

  UserResponseDto signUp(@Valid CreateUserRequestDto request);

  UserResponseDto signIn(@Valid UserSignInRequestDto request);

}
