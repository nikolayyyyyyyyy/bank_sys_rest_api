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

    @ExceptionHandler(value = {NotEnoughAmountException.class})
    public ResponseEntity<Object> handleNotEnoughAmountException(NotEnoughAmountException e){
        InsufficientAmountException ex =
                new InsufficientAmountException(e.getMessage(),
                        e.getCause(),
                        HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> handleNotEnoughAmountException(EntityAlreadyExistException e){
        DuplicatedEntityException ex =
                new DuplicatedEntityException(e.getMessage(),
                        e.getCause(),
                        HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
    }
}
