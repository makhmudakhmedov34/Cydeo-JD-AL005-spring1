package com.cydeo.controller;

import com.cydeo.model.AccountDetail;
import com.cydeo.model.UserAccount;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class HomeController {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<UserAccount> readAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<AccountDetail> readAllAccounts(){
        return accountRepository.findAll();
    }
}
