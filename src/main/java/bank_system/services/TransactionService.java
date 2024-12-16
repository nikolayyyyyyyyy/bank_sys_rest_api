package bank_system.services;

import bank_system.models.dtos.CreateTransactionDTO;
import bank_system.models.entities.Transaction;

import java.util.Set;

public interface TransactionService {

    public void createTransaction(CreateTransactionDTO transaction);
    public Transaction getTransactionById(long id);
    public Set<Transaction> getAllTransactions();
}
