package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
@Schema(name = "UserLoginDto",
        description = "Данные для аутентификации пользователя")
public class UserLoginDto {

    @Schema(description = "Логин пользователя")
    @Size(min = 5, max = 100, message = "Имя пользователя должно содержать от 5 до 100 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    String username;

    @Schema(description = "Пароль пользователя")
    @Size(min = 5, max = 255, message = "Пароль пользователя должен содержать от 5 до 255 символов")
    @NotBlank(message = "Пароль пользователя не может быть пустым")
    String password;
}
