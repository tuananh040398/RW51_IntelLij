package com.tn.service;

import com.tn.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    void delete(Integer id);

    void save(Account obj);

//    void update(Integer id, Account obj);
}
