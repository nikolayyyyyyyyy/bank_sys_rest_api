package bank_system.exceptions;

public class EntityNotFoundInDbException extends RuntimeException {
    public EntityNotFoundInDbException(String message) {
        super(message);
    }
}
