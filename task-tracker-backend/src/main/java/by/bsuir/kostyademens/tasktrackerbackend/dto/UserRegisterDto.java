package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
@Schema(name = "UserRegisterDto",
        description = "Данные для регистрации нового пользователя")
public class UserRegisterDto {

    @Schema(description = "Логин пользователя")
    @Size(min = 5, max = 100, message = "Имя пользователя должно содержать от 5 до 100 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    String username;

    @Schema(description = "Адрес электронной почты пользователя")
    @Size(min = 5, max = 100, message = "Адрес электронной почты должно содержать от 5 до 100 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Адрес электронной почты должен быть в формате user@example.com")
    String email;

    @Schema(description = "Пароль пользователя")
    @Size(min = 5, max = 255, message = "Пароль пользователя должен содержать от 5 до 255 символов")
    @NotBlank(message = "Пароль пользователя не может быть пустым")
    String password;
}
