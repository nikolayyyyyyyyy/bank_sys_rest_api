package bank_system.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicatedEntityException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public DuplicatedEntityException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public String getMessage() {
        return message;
    }
}
