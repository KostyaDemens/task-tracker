package by.bsuir.kostyademens.tasktrackerbackend.exception;

import java.time.Instant;

public record ExceptionResponse(
        int status,
        String error,
        String message,
        Instant timestamp
) {
}
