package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "UserDto",
        description = "Данные для регистрации нового пользователя")
public class UserDto {

    @Schema(description = "Имя пользователя")
    @Size(min = 5, max = 100, message = "Имя пользователя должно содержать максимум 100 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Адрес электронной почты пользователя")
    @Size(max = 100, message = "Адрес электронной почты может содеражть максимум 100 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Адрес электронной почты должен быть в формате user@example.com")
    private String email;

    @Schema(description = "Пароль")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;
}
