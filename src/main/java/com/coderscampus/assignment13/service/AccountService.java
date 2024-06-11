package com.coderscampus.assignment13.service;


import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    UserService userService;

    public Account findByAccountId(Long accountId) {
        return accountRepo.findByAccountId(accountId);
    }

    public Account addAccountToUser(User user) {
        Account account = new Account();

    }
}