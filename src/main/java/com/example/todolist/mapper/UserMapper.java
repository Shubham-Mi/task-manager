package com.example.todolist.mapper;

import com.example.todolist.dto.CreateUserRequestDto;
import com.example.todolist.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  User toUser(CreateUserRequestDto request);
}
