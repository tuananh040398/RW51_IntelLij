package com.tn.service;


import com.tn.entity.Department;
import com.tn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return departmentRepo.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public Page<Department> getAllDepartment(Pageable pageable) {
        return departmentRepo.findAll(pageable);
    }

    @Override
    public Department getById(Integer id) {
        Department department = departmentRepo.findById(id).get();
        return department;
    }

    @Override
    public void save(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> listAll(String keyword) {
        if(keyword != null){
            return departmentRepo.search(keyword);
        }
        return departmentRepo.findAll();
    }

}
