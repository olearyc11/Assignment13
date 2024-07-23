package com.coderscampus.assignment13.service;


import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    private final UserService userService;
    private final AccountRepository accountRepo;

    @Autowired
    public AccountService(@Lazy UserService userService, AccountRepository accountRepo) {
        this.userService = userService;
        this.accountRepo = accountRepo;
    }

    public Account findByAccountId(Long accountId) {
        return accountRepo.findByAccountId(accountId);
    }

    public Account addAccountToUser(User user) {
        int accountNumber = user.getAccounts().size() + 1;
        Account newAccount = new Account();
        newAccount.setAccountName("Account #" + accountNumber);

        newAccount.getUsers().add(user);
        user.getAccounts().add(newAccount);

        accountRepo.save(newAccount);

      userService.saveUser(user);

      return newAccount;
    }

    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }
}
