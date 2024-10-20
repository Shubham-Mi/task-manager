package com.example.todolist.service;

import com.example.todolist.dto.CreateTaskRequestDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.User;
import java.util.List;

public interface TaskService {

  TaskDto createTask(User user, CreateTaskRequestDto request);

  TaskDto getTaskById(User user, Long taskId);

  List<TaskDto> getAllTasks(User user);
}
