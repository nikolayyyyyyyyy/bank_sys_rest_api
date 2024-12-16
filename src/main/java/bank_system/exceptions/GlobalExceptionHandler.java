package bank_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundInDbException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundInDbException e){
        EntityNullException ex =
                new EntityNullException(e.getMessage(),
                        e.getCause(),
                        HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
    }
}
