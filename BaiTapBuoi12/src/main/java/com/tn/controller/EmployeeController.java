package com.tn.controller;

import com.tn.entity.Employee;
import com.tn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        List<Employee> employees = employeeRepo.getAllData();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("getoverthirtyfive")
    public ResponseEntity<?> getEmployeeAgeGreaterThanThirtyFive() {
        List<Employee> employees = employeeRepo.getEmployeeAgeGreaterThanThirtyFive();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("updatebyid/{id}")
    public ResponseEntity<?> updateEmployeeByid(@PathVariable Integer id) {
    employeeRepo.updateEmployeeById(id);
    return new ResponseEntity<>("update success", HttpStatus.OK);

    }

    @Transactional
    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<?> deleteEmoloyeeById(@PathVariable Integer id) {
        employeeRepo.deleteEmployeeById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }

    @GetMapping("getbyfullnameandage")
    public ResponseEntity<?> getEmployeeByFullNameAndAge(@RequestParam String fullName,
                                                         @RequestParam Integer age) {
        List<Employee> employees = employeeRepo.getEmployeeByFullNameAndAge(fullName, age);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
