package bank_system.models.entities;

import jakarta.persistence.*;
import bank_system.models.enums.TransactionType;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "account_of_sender_id")
    private Account accountOfSender;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_of_receiver_id")
    private Account accountOfReceiver;

    @Column(nullable = false)
    private double amount;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccountOfSender() {
        return accountOfSender;
    }

    public void setAccountOfSender(Account accountOfSender) {
        this.accountOfSender = accountOfSender;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccountOfReceiver() {
        return accountOfReceiver;
    }

    public void setAccountOfReceiver(Account accountOfReceiver) {
        this.accountOfReceiver = accountOfReceiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
