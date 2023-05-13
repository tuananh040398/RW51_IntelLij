package com.huytien.service;

import com.huytien.entity.Account;
import com.huytien.entity.Department;
import com.huytien.repository.IAccountRepository;
import com.huytien.repository.IDepartmentRepository;
import com.huytien.specification.DepartmentSpecification;
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

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository departmentRepo;

    @Autowired
    private IAccountRepository accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String seach) {

        Specification<Department> where = DepartmentSpecification.buildWhere(seach);
        return departmentRepo.findAll(where, pageable);
    }

    @Override
    public Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return departmentRepo.findAll(pageable);
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepo.findById(id).get();
    }

    @Override
    public void creatingDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void updateDepartmentById(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepo.deleteById(id);
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
