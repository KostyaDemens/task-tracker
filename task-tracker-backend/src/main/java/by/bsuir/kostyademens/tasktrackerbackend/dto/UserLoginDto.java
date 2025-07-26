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
    @Size(max = 100, message = "Логин пользователя может содеражть максимум 100 символов")
    @NotBlank(message = "Логин пользователя не может быть пустыми")
    String username;

    @Schema(description = "Пароль")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    String password;
}
