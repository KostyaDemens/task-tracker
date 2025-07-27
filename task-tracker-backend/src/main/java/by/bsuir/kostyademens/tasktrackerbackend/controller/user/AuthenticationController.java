package by.bsuir.kostyademens.tasktrackerbackend.controller.user;

import by.bsuir.kostyademens.tasktrackerbackend.dto.UserLoginDto;
import by.bsuir.kostyademens.tasktrackerbackend.dto.UserRegisterDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import by.bsuir.kostyademens.tasktrackerbackend.service.AuthenticationService;
import by.bsuir.kostyademens.tasktrackerbackend.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Void> register(@RequestBody UserRegisterDto userRegisterDto) {
        User user = authenticationService.register(userRegisterDto);

        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@RequestBody UserLoginDto userLoginDto) {
        User user = authenticationService.authenticate(userLoginDto);

        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
                .build();
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout() {
        SecurityContextHolder.clearContext();

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .header(HttpHeaders.AUTHORIZATION, "")
                .build();
    }

}
