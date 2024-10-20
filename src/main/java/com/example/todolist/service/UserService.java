package com.example.todolist.service;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.model.User;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {

  UserDetailsService userDetailsService();

  User createUser(@Valid CreateUserRequestDto request);

  User getUserByEmail(String email);
}
