package bank_system.services.impl;
import bank_system.exceptions.EntityNotFoundInDbException;
import bank_system.models.entities.Transaction;
import bank_system.repositories.TransactionRepository;
import bank_system.services.TransactionService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id).orElse(null);
        if(transaction == null){

            throw new EntityNotFoundInDbException("Transaction not found!");
        }

        this.transactionRepository.delete(transaction);
    }

    @Override
    public Transaction getTransactionById(long id) {
        Transaction transaction = this.transactionRepository.findById(id).orElse(null);
        if(transaction == null){

            throw new EntityNotFoundInDbException("Transaction not found!");
        }

        return transaction;
    }

    @Override
    public Set<Transaction> getAllTransactions() {
        if(this.transactionRepository.findAll().isEmpty()){

            throw new EntityNotFoundInDbException("Transaction table is empty!");
        }

        return new HashSet<>(this.transactionRepository.findAll());
    }
}
