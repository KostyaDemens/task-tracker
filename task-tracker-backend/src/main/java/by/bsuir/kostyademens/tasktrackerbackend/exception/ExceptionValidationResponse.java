package by.bsuir.kostyademens.tasktrackerbackend.exception;

import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
public class ExceptionValidationResponse extends ExceptionResponse {

    private final Map<String, List<String>> validationErrors;

    public ExceptionValidationResponse(int status, String error, String message, Instant timestamp, Map<String, List<String>> validationErrors) {
        super(status, error, message, timestamp);
        this.validationErrors = validationErrors;
    }
}
