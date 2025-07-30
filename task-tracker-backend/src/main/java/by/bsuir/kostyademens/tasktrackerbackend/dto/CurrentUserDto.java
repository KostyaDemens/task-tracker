package by.bsuir.kostyademens.tasktrackerbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
