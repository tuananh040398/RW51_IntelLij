package com.tn.service;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        accountRepo.deleteById(id);
    }

    @Override
    public void save(Account obj) {
        accountRepo.save(obj);
    }
//
//    @Override
//    public void update(Integer id, Account obj) {
//        accountRepo.save(obj);
//    }
}
