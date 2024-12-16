package bank_system.web;

import bank_system.exceptions.EntityNotFoundInDbException;
import bank_system.models.dtos.CreateTransactionDTO;
import bank_system.models.entities.Account;
import bank_system.models.entities.Client;
import bank_system.models.entities.Employee;
import bank_system.models.entities.Transaction;
import bank_system.services.AccountService;
import bank_system.services.ClientService;
import bank_system.services.EmployeeService;
import bank_system.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final AccountService accountService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

    public TransactionController(AccountService accountService,
                                 ClientService clientService,
                                 EmployeeService employeeService,
                                 TransactionService transactionService,
                                 ModelMapper modelMapper) {
        this.accountService = accountService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.transactionService = transactionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createTransaction(@RequestBody CreateTransactionDTO transactionDTO){
        Client client = this.clientService.getClientById(transactionDTO.getClientId());
        Employee employee = this.employeeService.getEmployeeById(transactionDTO.getEmployeeId());
        Account account = this.accountService.getAccountById(transactionDTO.getAccountId());

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setClient(client);
        transaction.setAccount(account);
        transaction.setEmployee(employee);

        this.transactionService.createTransaction(transaction);
        return "Transaction created successfully!";
    }

    public CreateTransactionDTO getTransaction(long id){
        return new CreateTransactionDTO();
    }

    public Set<CreateTransactionDTO> getAllTransactions(){
        return new HashSet<>();
    }
}
