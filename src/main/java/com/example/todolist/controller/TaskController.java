package com.example.todolist.controller;

import com.example.todolist.dto.CreateTaskRequestDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.User;
import com.example.todolist.service.TaskService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("/tasks")
  public ResponseEntity<List<TaskDto>> getAllTasks(@AuthenticationPrincipal User user) {
    return ResponseEntity.ok(taskService.getAllTasks(user));
  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity<TaskDto> getTaskById(@AuthenticationPrincipal User user, @PathVariable Long id) {
    return ResponseEntity.ok(taskService.getTaskById(user, id));
  }

  @PostMapping("/tasks")
  public ResponseEntity<TaskDto> createTask(@AuthenticationPrincipal User user, @RequestBody CreateTaskRequestDto request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(user, request));
  }
}
