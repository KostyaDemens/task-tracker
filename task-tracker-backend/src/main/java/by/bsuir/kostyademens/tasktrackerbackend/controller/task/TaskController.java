package by.bsuir.kostyademens.tasktrackerbackend.controller.task;

import by.bsuir.kostyademens.tasktrackerbackend.dto.TaskDto;
import by.bsuir.kostyademens.tasktrackerbackend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<TaskDto> getAllTasks() {
        return null;
    }
}
