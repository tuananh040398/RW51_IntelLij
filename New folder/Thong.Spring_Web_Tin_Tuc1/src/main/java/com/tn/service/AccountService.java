package com.tn.service;

import com.tn.account.CreatingAccountForm;
import com.tn.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account getById(Integer id);

    void createAccount(CreatingAccountForm form);

    void delete(Integer id);

    void save(Account account);


}
