package by.bsuir.kostyademens.tasktrackerbackend.controller.user;

import by.bsuir.kostyademens.tasktrackerbackend.dto.UserLoginDto;
import by.bsuir.kostyademens.tasktrackerbackend.dto.UserRegisterDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import by.bsuir.kostyademens.tasktrackerbackend.service.AuthenticationService;
import by.bsuir.kostyademens.tasktrackerbackend.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterDto userRegisterDto, HttpServletResponse response) {
        User user = authenticationService.register(userRegisterDto);

        String jwtToken = jwtService.generateToken(user);

        response.setHeader("Authorization", "Bearer " + jwtToken);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        User user = authenticationService.authenticate(userLoginDto);

        String jwtToken = jwtService.generateToken(user);

        response.setHeader("Authorization", "Bearer " + jwtToken);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        response.setHeader("Authorization", "");
        SecurityContextHolder.clearContext();

        return ResponseEntity.ok().build();

        //TODO Проверить, какие коды доступа везде возвращаем
    }

}
