package by.bsuir.kostyademens.tasktrackerbackend.controller;

import by.bsuir.kostyademens.tasktrackerbackend.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.error(exception.getMessage(), exception);

        return buildExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        log.error(exception.getMessage(), exception);

        return buildExceptionResponse(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        log.error(exception.getMessage(), exception);

        if (request.getRequestURI().equals("/auth/login")) {
            return buildExceptionResponse(HttpStatus.UNAUTHORIZED, "Login or password is incorrect");
        }

        Map<String, List<String>> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));

        ExceptionResponse exceptionResponse = new ExceptionValidationResponse(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation error",
                Instant.now(),
                errors
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    private ResponseEntity<ExceptionResponse> handleWrongCredentialException(WrongCredentialsException exception) {
        log.error(exception.getMessage(), exception);

        return buildExceptionResponse(HttpStatus.UNAUTHORIZED, exception.getMessage());
    }

    private ResponseEntity<ExceptionResponse> buildExceptionResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        httpStatus.value(),
                        httpStatus.getReasonPhrase(),
                        message,
                        Instant.now()
                ),
                httpStatus
        );
    }
}
