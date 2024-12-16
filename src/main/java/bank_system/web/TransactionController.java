package bank_system.web;
import bank_system.models.dtos.CreateTransactionDTO;
import bank_system.models.dtos.TransactionDTO;
import bank_system.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final ModelMapper modelMapper;

    public TransactionController (TransactionService transactionService,
                                 ModelMapper modelMapper) {
        this.transactionService = transactionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public String createTransaction(@RequestBody CreateTransactionDTO transactionDTO){
        this.transactionService.createTransaction(transactionDTO);
        return "Transaction created successfully!";
    }

    @GetMapping("{id}")
    public TransactionDTO getTransaction(@PathVariable(name = "id")long id){
        return this.modelMapper.map(this.transactionService.getTransactionById(id),
                TransactionDTO.class);
    }

    @GetMapping
    public Set<TransactionDTO> getAllTransactions(){
        return this.transactionService.getAllTransactions()
                .stream()
                .map(t -> modelMapper.map(t, TransactionDTO.class))
                .collect(Collectors.toSet());
    }
}
