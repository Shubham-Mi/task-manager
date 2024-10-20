package com.example.todolist.service.impl;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.dto.UserSignInRequestDto;
import com.example.todolist.model.User;
import com.example.todolist.service.AuthenticationService;
import com.example.todolist.service.JwtService;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final JwtService jwtService;
  private final UserService userService;
  private final AuthenticationManager authenticationManager;

  @Override
  public UserResponseDto signUp(CreateUserRequestDto request) {
    User user = userService.createUser(request);
    log.info("User created: {}", user);
    return UserResponseDto.builder()
        .token(jwtService.generateToken(user))
        .build();
  }

  @Override
  public UserResponseDto signIn(UserSignInRequestDto request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    User user = userService.getUserByEmail(request.getEmail());
    return UserResponseDto.builder()
        .token(jwtService.generateToken(user))
        .build();
  }
}
