package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
@Schema(name = "TaskDto",
        description = "Пользовательская задача")
public class TaskDto {

    @Schema(description = "Заголовок задачи")
    @Size(max = 100, message = "Заголовок задачи может содержать до 100 символов")
    @NotBlank(message = "Заголовок задачи не может быть пустым")
    String title;

    @Schema(description = "Описание задачи")
    @NotBlank(message = "Описание задачи не может быть пустым")
    String description;

}
