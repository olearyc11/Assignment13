package com.coderscampus.assignment13.web;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
        accountService.addAccountToUser(user);
        return "redirect:/users/"+user.getUserId();
    }




}
