package by.bsuir.kostyademens.tasktrackerbackend.controller;

import by.bsuir.kostyademens.tasktrackerbackend.dto.UserLoginDto;
import by.bsuir.kostyademens.tasktrackerbackend.dto.UserRegisterDto;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import by.bsuir.kostyademens.tasktrackerbackend.service.AuthenticationService;
import by.bsuir.kostyademens.tasktrackerbackend.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserRegisterDto userRegisterDto, HttpServletResponse httpServletResponse) {
        User user = authenticationService.register(userRegisterDto);

        String jwtToken = jwtService.generateToken(user);

        httpServletResponse.setHeader("Authorization", "Bearer " + jwtToken);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        User user = authenticationService.authenticate(userLoginDto);

        String jwtToken = jwtService.generateToken(user);

        response.setHeader("Authorization", "Bearer " + jwtToken);

        return ResponseEntity.ok().build();
    }
}
