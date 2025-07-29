package by.bsuir.kostyademens.tasktrackerbackend.controller.user;

import by.bsuir.kostyademens.tasktrackerbackend.dto.CurrentUserDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<CurrentUserDto> getCurrentUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(new CurrentUserDto(user.getId(), user.getUsername()));
    }
}
