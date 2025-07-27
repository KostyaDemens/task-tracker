package by.bsuir.kostyademens.tasktrackerbackend.service;

import by.bsuir.kostyademens.tasktrackerbackend.dto.UserLoginDto;
import by.bsuir.kostyademens.tasktrackerbackend.dto.UserRegisterDto;
import by.bsuir.kostyademens.tasktrackerbackend.exception.UserAlreadyExistsException;
import by.bsuir.kostyademens.tasktrackerbackend.model.User;
import by.bsuir.kostyademens.tasktrackerbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User register(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
            throw new UserAlreadyExistsException(
                    "User with username '" + userRegisterDto.getUsername() + "' already exists"
            );
        }

        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new UserAlreadyExistsException(
                    "User with email '" + userRegisterDto.getEmail() + "' already exists"
            );
        }

        User user = User.builder()
                .email(userRegisterDto.getEmail())
                .username(userRegisterDto.getUsername())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public User authenticate(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getUsername(),
                        userLoginDto.getPassword()
                )
        );

        return userRepository.findByUsername(userLoginDto.getUsername())
                .orElseThrow();
    }


}
