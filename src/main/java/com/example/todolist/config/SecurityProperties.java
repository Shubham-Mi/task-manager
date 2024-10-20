package com.example.todolist.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class SecurityProperties {

  @Value("${security.jwt.secret}")
  private String secret;

  @Value("${security.jwt.expiration}")
  private long expirationInMs;

  @Value("${security.admin.username}")
  private String adminUsername;

  @Value("${security.admin.password}")
  private String adminPassword;
}
