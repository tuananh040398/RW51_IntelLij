package com.tn.service;

import com.tn.entity.Department;
import com.tn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepo;

    @Override
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getById(Integer id) {
        Department department = departmentRepo.findById(id).get();
        return department;
    }


    @Override
    public void delete(Integer id) {
        departmentRepo.deleteById(id);

    }

    @Override
    public void save(Department department) {
        departmentRepo.save(department);

    }


}
