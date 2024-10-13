package com.example.todolist.service;

public interface JwtService {

  String generateToken(String email);

  String getEmailFromToken(String token);
}
