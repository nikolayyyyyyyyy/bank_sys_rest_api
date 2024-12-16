package bank_system.services.impl;
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
        this.transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransactionById(long id) {
        return this.transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Transaction> getAllTransactions() {
        return new HashSet<>(this.transactionRepository.findAll());
    }
}
