package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
@Schema(name = "CurrentUserDto",
        description = "Данные текущего пользователя")
public class CurrentUserDto {

    @Schema(description = "Id текущего пользователя")
    Long id;

    @Schema(description = "Адрес электронной почты пользователя")
    String username;

}
