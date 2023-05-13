package com.tn.controller;

import com.tn.entity.Employee;
import com.tn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping
    public Page<Employee> getAll(Pageable pageable){
        Page<Employee> employees = employeeRepo.findAll(pageable);
        return employees;
    }
}
