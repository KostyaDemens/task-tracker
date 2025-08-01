package by.bsuir.kostyademens.tasktrackerbackend.dto;

import by.bsuir.kostyademens.tasktrackerbackend.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Value
@Schema(name = "TaskDto",
        description = "Пользовательская задача")
public class TaskDto {

    @Schema(name = "ID задачи")
    Long id;

    @Schema(name = "Заголовок задачи")
    String title;

    @Schema(name = "Описание задачи")
    String description;

    @Schema(name = "Статус задачи")
    TaskStatus status;

    @Schema(name = "Время создания задачи")
    LocalDateTime createdAt;

    @Schema(name = "Флаг. Выполнена задача или нет")
    boolean isDone;

}


