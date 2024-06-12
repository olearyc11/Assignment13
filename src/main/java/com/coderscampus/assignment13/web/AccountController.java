package com.coderscampus.assignment13.web;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @PostMapping("/users/{userId}/accounts")
    public String createNewAccount(@PathVariable Long userId) {
        User user = userService.findById(userId);
        Account account = accountService.addAccountToUser(user);
        return "redirect:/users/" + userId + "/accounts/" + account.getAccountId();
    }

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String displayAccounts(@PathVariable Long userId, @PathVariable Long accountId, ModelMap model) {
        User user = userService.findById(userId);
        Account account = accountService.findByAccountId(accountId);
        model.put("user", user);
        model.put("account", account);
        return "account";
    }

    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String saveUpdateAccount(@PathVariable Long userId, @PathVariable Long accountId, Account account) {
        User user = userService.findById(userId);
        Account existingAccount = accountService.findByAccountId(accountId);
        existingAccount.setAccountName(account.getAccountName());
        accountService.saveAccount(existingAccount);
        return "redirect:/users/" + user.getUserId() + "/accounts/" + account.getAccountId();
    }



}
