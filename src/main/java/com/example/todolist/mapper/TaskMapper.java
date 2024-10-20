package com.example.todolist.mapper;

import com.example.todolist.dto.CreateTaskRequestDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.Task;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

  TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

  Task toTask(CreateTaskRequestDto taskRequestDto, Long userId);

  TaskDto toCreateTaskResponseDto(Task task);

  List<TaskDto> toTaskDtoList(List<Task> tasks);
}
