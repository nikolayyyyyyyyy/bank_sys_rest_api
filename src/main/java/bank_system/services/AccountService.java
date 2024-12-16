package bank_system.services;

import bank_system.models.entities.Account;

import java.util.Set;

public interface AccountService {

    public void createAccount(Account account);
    public Account getAccountById(long id);
    public Set<Account> getAllAccounts();
}
