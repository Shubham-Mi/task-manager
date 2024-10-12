package com.example.todolist.service.impl;

import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
}
