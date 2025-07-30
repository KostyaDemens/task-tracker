package by.bsuir.kostyademens.tasktrackerbackend.service;

import by.bsuir.kostyademens.tasktrackerbackend.TaskStatus;
import by.bsuir.kostyademens.tasktrackerbackend.dto.TaskDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.Task;
import by.bsuir.kostyademens.tasktrackerbackend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<TaskDto> getAllTasks(Long userId) {
        return taskRepository.findAllByUserId(userId)
                .stream().map(task -> new TaskDto(
                        task.getTitle(),
                        task.getDescription()
                )).toList();
    }

    public void add(TaskDto taskDto) {
        taskRepository.save(Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(TaskStatus.NEW)
                .createdAt(LocalDateTime.now())
                .isDone(false)
                .build());
    }

    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
