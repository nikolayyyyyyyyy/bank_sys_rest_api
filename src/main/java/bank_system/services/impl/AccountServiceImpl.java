package bank_system.services.impl;
import bank_system.exceptions.EntityNotFoundInDbException;
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
        Account account = this.accountRepository.findById(id).orElse(null);
        if(account == null){

            throw new EntityNotFoundInDbException("Account not found!");
        }

        this.accountRepository.delete(account);
    }

    @Override
    public Account getAccountById(long id) {
        Account account = this.accountRepository.findById(id).orElse(null);
        if(account == null){

            throw new EntityNotFoundInDbException("Account not found!");
        }

        return account;
    }

    @Override
    public Set<Account> getAllAccounts() {
        if(this.accountRepository.findAll().isEmpty()){

            throw new EntityNotFoundInDbException("Account table is empty!");
        }

        return new HashSet<>(this.accountRepository.findAll());
    }

    @Override
    public Account getAccountByNumber(String number) {
        if(this.accountRepository.findByNumber(number) == null){

            throw new EntityNotFoundInDbException("Account not found!");
        }

        return this.accountRepository.findByNumber(number);
    }
}
