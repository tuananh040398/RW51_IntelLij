package com.huytien.service;

import com.huytien.entity.Account;
import com.huytien.entity.Department;
import com.huytien.from.AccountFormFilter;
import com.huytien.from.CreatingAccountForm;
import com.huytien.from.UpdateAccountForm;
import com.huytien.repository.IAccountRepository;
import com.huytien.repository.IDepartmentRepository;
import com.huytien.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private IDepartmentRepository departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFormFilter filter) {

        Specification<Account> where = AccountSpecification.buildWhere(search, filter);
        return accountRepo.findAll(where, pageable);
    }

    @Override
    public Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return accountRepo.findAll(pageable);
    }

    @Override
    public void createAccount(CreatingAccountForm form) {

        // Cách này lỗi khi add data thứ 2 vào.
//        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
//        modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
//            @Override
//            protected void configure() {
//                skip(destination.getId());
//            }
//        });
//        Account account = modelMapper.map(form, Account.class);

        Department department = departmentRepo.findById(form.getDepartmentId()).get();

        Account account = new Account();
        account.setUsername(form.getUsername());
        account.setFirstName(form.getFirstName());
        account.setLastName(form.getLastName());
        account.setRole(form.getRole());
        account.setDepartment(department);

        accountRepo.save(account);
    }

    @Override
    public boolean isAccountExistsByUsername(String username) {

        return accountRepo.existsAccountByUsername(username);
    }

    @Override
    public void deleteById(Integer id) {
        accountRepo.deleteById(id);
    }

    @Override
    public Account getById(Integer id) {
        Account account = accountRepo.findById(id).get();
        return account;
    }

    @Override
    public void update(UpdateAccountForm form) {

        Department department = departmentRepo.findById(form.getDepartmentId()).get();

        Account account = accountRepo.findById(form.getId()).get();
//        account.setUsername(form.getUsername());
//        account.setFirstName(form.getFirstName());
//        account.setLastName(form.getLastName());
        account.setRole(form.getRole());
        account.setDepartment(department);

        accountRepo.save(account);
    }

    @Override
    public void deleteAccountsByIds(List<Integer> ids) {
        accountRepo.deleteByIds(ids);
    }

    @Override
    public Account getAccountByUsername(String username) {

        return accountRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);

        if(account == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(
                account.getUsername(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole().toString())
        );
    }
}
