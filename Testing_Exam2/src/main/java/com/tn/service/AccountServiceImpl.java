package com.tn.service;

import com.tn.entity.Account;
import com.tn.repository.AccountrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountrRepository accountrRepo;

    @Override
    public List<Account> getAll() {
        return accountrRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        accountrRepo.deleteById(id);
    }

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountrRepo.findAll(pageable);
    }

    @Override
    public Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return accountrRepo.findAll(pageable);
    }

    @Override
    public Account getById(Integer id) {
        Account account = accountrRepo.findById(id).get();
        return account;
    }

    @Override
    public void save(Account account) {
        accountrRepo.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountrRepo.findByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException("Account not found: " + username);
        }

        return new User(username, account.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(account.getRole())));
    }

    @Override
    public List<Account> listAll(String keyword) {
        if(keyword != null){
            return accountrRepo.search(keyword);
        }
        return accountrRepo.findAll();
    }
}
