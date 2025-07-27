package by.bsuir.kostyademens.tasktrackerbackend.controller;

import by.bsuir.kostyademens.tasktrackerbackend.exception.ExceptionResponse;
import by.bsuir.kostyademens.tasktrackerbackend.exception.UserAlreadyExistsException;
import by.bsuir.kostyademens.tasktrackerbackend.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.error(exception.getMessage(), exception);

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                Instant.now()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserUserAlreadyExistsException(UserAlreadyExistsException exception) {
        log.error(exception.getMessage(), exception);

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                Instant.now()
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }
}
