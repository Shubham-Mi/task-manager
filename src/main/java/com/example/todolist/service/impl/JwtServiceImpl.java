package com.example.todolist.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.todolist.config.SecurityProperties;
import com.example.todolist.service.JwtService;
import java.time.Instant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtServiceImpl implements JwtService {

  private final SecurityProperties properties;

  @Override
  public String generateToken(String email) {
    return JWT.create()
        .withSubject(email)
        .withIssuedAt(Instant.now())
        .withExpiresAt(Instant.now().plusSeconds(properties.getExpiration()))
        .sign(getAlgorithm());
  }

  @Override
  public String getEmailFromToken(String token) {
    return JWT.require(getAlgorithm())
        .build()
        .verify(token)
        .getSubject();
  }

  private Algorithm getAlgorithm() {
    return Algorithm.HMAC256(properties.getSecret());
  }
}
