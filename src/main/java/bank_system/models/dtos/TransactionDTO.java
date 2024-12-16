package bank_system.models.dtos;
import bank_system.models.enums.TransactionType;

public class TransactionDTO {

    private TransactionType transactionType;

    private AccountDTO accountOfSender;

    private AccountDTO accountOfReceiver;

    private double amount;

    public TransactionDTO() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public AccountDTO getAccountOfSender() {
        return accountOfSender;
    }

    public void setAccountOfSender(AccountDTO accountOfSender) {
        this.accountOfSender = accountOfSender;
    }

    public AccountDTO getAccountOfReceiver() {
        return accountOfReceiver;
    }

    public void setAccountOfReceiver(AccountDTO accountOfReceiver) {
        this.accountOfReceiver = accountOfReceiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
