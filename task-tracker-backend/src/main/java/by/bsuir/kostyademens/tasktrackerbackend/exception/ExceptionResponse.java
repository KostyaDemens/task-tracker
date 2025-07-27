package by.bsuir.kostyademens.tasktrackerbackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class ExceptionResponse {

    private final int status;
    private final String error;
    private final String message;
    private final Instant timestamp;

}

