package com.huytien.service;

import com.huytien.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IDepartmentService extends UserDetailsService {

    public Page<Department> getAllDepartments(Pageable pageable, String seach);

    Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    public Department findById(Integer id);

    public void creatingDepartment(Department department);

    public void updateDepartmentById(Department department);

    public void deleteDepartmentById(Integer id);
}

