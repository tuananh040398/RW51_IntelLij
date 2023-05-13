package com.tn.service;

import com.tn.account.CreatingAccountForm;
import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(Integer id) {
        Account account = accountRepo.findById(id).get();
        return account;
    }

    @Override
    public void createAccount(CreatingAccountForm form) {
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        Account account = modelMapper.map(form, Account.class);

        accountRepo.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountRepo.deleteById(id);
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account)
        ;
    }


}
