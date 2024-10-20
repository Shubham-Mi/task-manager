package com.example.todolist.service.impl;

import static com.example.todolist.mapper.TaskMapper.MAPPER;

import com.example.todolist.dto.CreateTaskRequestDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.TaskService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  @Override
  public TaskDto createTask(User user, CreateTaskRequestDto request) {
    Task task = MAPPER.toTask(request, user.getId());
    task = taskRepository.save(task);
    return MAPPER.toCreateTaskResponseDto(task);
  }

  @Override
  public TaskDto getTaskById(User user, Long taskId) {
    return taskRepository.findByIdAndUserId(taskId, user.getId())
        .map(MAPPER::toCreateTaskResponseDto)
        .orElseThrow(() -> new IllegalArgumentException("Task not found"));
  }

  @Override
  public List<TaskDto> getAllTasks(User user) {
    List<Task> tasks = taskRepository.findAllByUserId(user.getId());
    return MAPPER.toTaskDtoList(tasks);
  }
}
