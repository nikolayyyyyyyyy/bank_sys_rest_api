package bank_system.models.dtos;
import bank_system.models.enums.TransactionType;

public class CreateTransactionDTO {

    private TransactionType transactionType;

    private int senderAccountId;

    private int employeeId;

    private int receiverAccountId;

    private double amount;

    public CreateTransactionDTO() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
