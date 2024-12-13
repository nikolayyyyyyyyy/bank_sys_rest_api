package bank_system.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "middle_name",nullable = false,length = 50)
    private String middleName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String egn;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "client")
    private Set<Account> accounts;

    public Client() {
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }
}
