package com.tn.service;


import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        System.out.println(account);

        if (account == null) {
            throw new UsernameNotFoundException("Account not found: " + username);
        }

            return new User(username, account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
