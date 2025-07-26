package by.bsuir.kostyademens.tasktrackerbackend.controller.user;

import by.bsuir.kostyademens.tasktrackerbackend.dto.CurrentUserDto;
import by.bsuir.kostyademens.tasktrackerbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/me")
    public ResponseEntity<CurrentUserDto> getCurrentUser(Authentication authentication) {

        CurrentUserDto currentUserDto = userService.getCurrentUser(authentication);

        return ResponseEntity.ok(currentUserDto);
    }
}
