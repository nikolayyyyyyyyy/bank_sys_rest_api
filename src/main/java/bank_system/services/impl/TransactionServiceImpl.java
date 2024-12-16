package bank_system.services.impl;
import bank_system.exceptions.EntityNotFoundInDbException;
import bank_system.exceptions.NotEnoughAmountException;
import bank_system.models.dtos.CreateTransactionDTO;
import bank_system.models.entities.Account;
import bank_system.models.entities.Employee;
import bank_system.models.entities.Transaction;
import bank_system.repositories.TransactionRepository;
import bank_system.services.AccountService;
import bank_system.services.ClientService;
import bank_system.services.EmployeeService;
import bank_system.services.TransactionService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final AccountService accountService;
    private final EmployeeService employeeService;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountService accountService,
                                  EmployeeService employeeService,
                                  TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void createTransaction(CreateTransactionDTO transactionDTO) {
        Account accountOfSender = this.accountService.getAccountById(transactionDTO.getSenderAccountId());
        Employee employee = this.employeeService.getEmployeeById(transactionDTO.getEmployeeId());
        Account accountOfReceiver = this.accountService.getAccountById(transactionDTO.getReceiverAccountId());

        if(accountOfSender.getBalance() < transactionDTO.getAmount()){

            throw new NotEnoughAmountException("Client does not have enough money to make this transfer!");
        }

        accountOfSender.setBalance(accountOfSender.getBalance() - transactionDTO.getAmount());
        accountOfReceiver.setBalance(accountOfReceiver.getBalance() + transactionDTO.getAmount());

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setAccountOfSender(accountOfSender);
        transaction.setAccountOfReceiver(accountOfReceiver);
        transaction.setEmployee(employee);

        this.transactionRepository.save(transaction);
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
