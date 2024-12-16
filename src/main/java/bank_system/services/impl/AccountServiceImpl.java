package bank_system.services.impl;
import bank_system.models.entities.Account;
import bank_system.repositories.AccountRepository;
import bank_system.services.AccountService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(long id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public Account getAccountById(long id) {
        return this.accountRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Account> getAllAccounts() {
        return new HashSet<>(this.accountRepository.findAll());
    }

    @Override
    public Account getAccountByNumber(String number) {
        return this.accountRepository.findByNumber(number);
    }
}
