package by.bsuir.kostyademens.tasktrackerbackend.controller.task;

import by.bsuir.kostyademens.tasktrackerbackend.dto.TaskDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import by.bsuir.kostyademens.tasktrackerbackend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll(@AuthenticationPrincipal User user) {

        List<TaskDto> tasks = taskService.getAllTasks(user.getId());

        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody TaskDto taskDto, @AuthenticationPrincipal User user) {

        taskService.add(taskDto, user);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long taskId) {

        taskService.delete(taskId);

        return ResponseEntity.ok().build();
    }


}
