package com.example.todolist.controller;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.dto.UserResponseDto;
import com.example.todolist.dto.UserSignInRequestDto;
import com.example.todolist.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<UserResponseDto> signUp(@RequestBody CreateUserRequestDto request) {
    UserResponseDto response = authenticationService.signUp(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/signin")
  public ResponseEntity<UserResponseDto> signIn(@RequestBody UserSignInRequestDto request) {
    UserResponseDto response = authenticationService.signIn(request);
    return ResponseEntity.ok(response);
  }
}
