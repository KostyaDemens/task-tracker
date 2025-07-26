package by.bsuir.kostyademens.tasktrackerbackend.service;

import by.bsuir.kostyademens.tasktrackerbackend.dto.CurrentUserDto;
import by.bsuir.kostyademens.tasktrackerbackend.exception.UserNotFoundException;
import by.bsuir.kostyademens.tasktrackerbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CurrentUserDto getCurrentUser(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName())
                .map(user -> new CurrentUserDto(user.getId(), user.getUsername()))
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
