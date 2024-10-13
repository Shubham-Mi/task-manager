package com.example.todolist.service.impl;

import static com.example.todolist.mapper.UserMapper.MAPPER;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.dto.CreateUserResponseDto;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.JwtService;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public CreateUserResponseDto createUser(CreateUserRequestDto request) {
    log.info("Creating new user with email: {}", request.getEmail());
    User user = MAPPER.toUser(request);
    user.setPassword(encodePassword(request.getPassword()));
    User savedUser = userRepository.save(user);
    log.info("User with email: {} has been created", savedUser.getEmail());
    return CreateUserResponseDto.builder()
        .token(jwtService.generateToken(savedUser.getEmail()))
        .build();
  }

  private String encodePassword(String password) {
    return encoder.encode(password);
  }
}
