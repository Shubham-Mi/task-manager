package com.example.todolist.service.impl;

import static com.example.todolist.mapper.UserMapper.MAPPER;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public void createUser(CreateUserRequestDto request) {
    User user = MAPPER.toUser(request);
    user.setPassword(encodePassword(request.getPassword()));
    User savedUser = userRepository.save(user);
  }

  private String encodePassword(String password) {
    return encoder.encode(password);
  }
}
