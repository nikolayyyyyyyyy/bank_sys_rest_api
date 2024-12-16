package bank_system.services;

import bank_system.models.entities.Transaction;

import java.util.Set;

public interface TransactionService {

    public void createTransaction(Transaction transaction);
    public void updateTransaction(Transaction transaction);
    public void deleteTransactionById(long id);
    public Transaction getTransactionById(long id);
    public Set<Transaction> getAllTransactions();
}
