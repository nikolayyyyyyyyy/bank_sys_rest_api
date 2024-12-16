package bank_system.exceptions;

public class NotEnoughAmountException extends RuntimeException {
    public NotEnoughAmountException(String message) {
        super(message);
    }
}
