package com.tn.service;

import com.tn.entity.Account;
import com.tn.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DepartmentService {

    List<Department> getAll();

    Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    void delete(Integer id);

    public Page<Department> getAllDepartment(Pageable pageable);

    Department getById(Integer id);

    void save(Department department);

    List<Department> listAll(String keyword);

}
