package bank_system.models.entities;

import jakarta.persistence.*;
import bank_system.models.enums.Currency;

import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false)
    private double balance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "accountOfSender")
    private Set<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "accountOfReceiver")
    private Set<Transaction> incomingTransactions;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
