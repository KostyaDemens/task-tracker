package by.bsuir.kostyademens.tasktrackerbackend.service;

import by.bsuir.kostyademens.tasktrackerbackend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
}
