package com.coderscampus.assignment13.service;


import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    AccountRepository accountRepo;
    @Autowired
    UserService userService;

    public Account findByAccountId(Long accountId) {
        return accountRepo.findByAccountId(accountId);
    }


    public Account addAccountToUser(User user) {
        int accountNumber = user.getAccounts().size();
        Account newAccount = new Account();
        newAccount.setAccountName("Account #" + accountNumber);

        newAccount.getUsers().add(user);
        user.getAccounts().add(newAccount);

        Account savedAccount = accountRepo.save(newAccount);

      userRepo.save(user);

      return newAccount;
    }

    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }
}
