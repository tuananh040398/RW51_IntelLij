package com.huytien.service;

import com.huytien.entity.Account;
import com.huytien.entity.Department;
import com.huytien.from.AccountFormFilter;
import com.huytien.from.CreatingAccountForm;
import com.huytien.from.UpdateAccountForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {

    public Page<Account> getAllAccounts(Pageable pageable, String seach, AccountFormFilter filter);

    Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    public void createAccount(CreatingAccountForm form);

    public boolean isAccountExistsByUsername(String name);

    public void deleteById(Integer id);

    public Account getById(Integer id);

    public void update(UpdateAccountForm form);

    public void deleteAccountsByIds(List<Integer> ids);

    public Account getAccountByUsername(String username);

}
