package com.tn.controller;

import com.tn.entity.Department;
import com.tn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class DepartmentController {

    @Autowired

    private DepartmentRepository departmentRepo;

//    Get All (GetMapping)
    @GetMapping("department")
    public List<Department> getAll() {
        List<Department> departments = departmentRepo.findAll();
        departments.forEach(department -> {
            System.out.println(department.getDepartmentName());
            System.out.println(department.getDescritption());
        });
        return departments;
    }

//    Get By Id (GetMapping)
//    @GetMapping("department/{departmentId}")
//    public Department getById(@PathVariable CriteriaBuilder.In departmentId) {
//        Department department = departmentRepo.findById(departmentId).get();
//
//        return department;
//    }

//    Save Data (PostMapping)
    @PostMapping("department")
    public String saveData(@RequestBody Department obj) {
        departmentRepo.save(obj);

        return "save success";
    }

//    Update Data (PutMapping)
    @PutMapping("department/{id}")
    public String update(@PathVariable Integer id, @RequestBody Department obj) {
        obj.setId(id);
        departmentRepo.save(obj);

        return "update success";
    }

//    Delete (DeleteMapping)
    @DeleteMapping("department")
    public String delete(@PathVariable Integer departmentId) {
        Department department = departmentRepo.findById(departmentId).get();

        departmentRepo.delete(department);
        return "delete success";
    }


//    @PutMapping("department/update")
//    public String update() {
//        Department department3 = departmentRepo.findById(2).get();
//        department3.setDepartmentName("day la phong HCNS");
//
//        departmentRepo.save(department3);
//
//        return"update success";
//    }

    //    @PostMapping("department/save")
//    public String save() {
//        Department department1 = new Department(1, "Sale", "phong sale");
//        Department department2 = new Department(2, "HCNS", "phong HCNS");
//        departmentRepo.save(department1);
//        departmentRepo.save(department2);
//
//        return "save success";
//    }
}
