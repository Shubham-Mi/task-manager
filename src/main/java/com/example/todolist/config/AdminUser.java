package com.example.todolist.config;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AdminUser implements CommandLineRunner {

  private final UserRepository userRepository;
  private final UserService userService;
  private final SecurityProperties properties;

  @Override
  public void run(String... args) {
    if (userRepository.count() == 0) {
      CreateUserRequestDto adminRequest = CreateUserRequestDto.builder()
          .name("admin")
          .email(properties.getAdminUsername())
          .password(properties.getAdminPassword())
          .build();
      User adminUser = userService.createUser(adminRequest);
      log.debug("created ADMIN user - {}", adminUser);
    }
  }
}
