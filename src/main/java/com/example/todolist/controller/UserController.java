package com.example.todolist.controller;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto request) {
    userService.createUser(request);
    return ResponseEntity.created(null).build();
  }
}
