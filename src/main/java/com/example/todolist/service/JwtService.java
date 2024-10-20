package com.example.todolist.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

  String extractUserName(String token);

  String generateToken(UserDetails userDetails);

  boolean validateToken(String jwt, UserDetails userDetails);
}
