package com.tn.service;

import com.tn.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface AccountService extends UserDetailsService{

    List<Account> getAll();

    public Page<Account> getAllAccounts(Pageable pageable);

    Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    void delete(Integer id);

    Account getById(Integer id);

    void save(Account account);

    List<Account> listAll(String keyword);
}
