package com.tn.controller;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping("getByFullName")
    public ResponseEntity<?> getByFullName(@RequestParam String fullName){
        List<Account> accounts = accountRepo.findByFullName(fullName);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("getByAgeGreater")
    public ResponseEntity<?> getByAgeGreater(@RequestParam Integer age) {
        List<Account> accounts = accountRepo.findByAgeGreaterThan(age);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("getByName")
    public ResponseEntity<?> getByName(@RequestParam String fullName) {
        fullName = "%" + fullName;
        List<Account> accounts = accountRepo.findByFullNameLike(fullName);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("getByFullNameNull")
    public ResponseEntity<?> getByFullNameNull() {
        List<Account> accounts = accountRepo.findByFullNameIsNull();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
