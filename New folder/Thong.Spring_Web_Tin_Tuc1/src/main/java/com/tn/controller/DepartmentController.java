package com.tn.controller;

import com.tn.dto.DepartmentDTO;
import com.tn.entity.Department;
import com.tn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public String getAll(Model model){
        List<Department> departments = departmentService.getAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departments.forEach(obj ->{
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(obj.getId());
            departmentDTO.setDepartmentName(obj.getDepartmentName());

            departmentDTOS.add(departmentDTO);
        });
        System.out.println(departmentDTOS);
        model.addAttribute("listDepartment",departmentDTOS);
        return "department-list";

    }


    @GetMapping("add")
    public String add(){
        return "department-add";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Department department){
        System.out.println("department");
        System.out.println(department);
        return "department-add";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Department department){
        System.out.println(department);
        departmentService.save(department);
        return "redirect:/department";
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        System.out.println(id);
        departmentService.delete(id);
        return "redirect:/department";
    }

    @GetMapping("edit/{id}")
    public  String edit(@PathVariable Integer id,Model model){
        Department department = departmentService.getById(id);
        model.addAttribute("department",department);
        return "department-edit";
    }
}
