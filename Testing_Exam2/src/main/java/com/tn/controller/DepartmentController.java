package com.tn.controller;

import com.tn.dto.DepartmentDTO;
import com.tn.entity.Account;
import com.tn.entity.Department;
import com.tn.repository.DepartmentRepository;
import com.tn.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentService departmentService;

//    @GetMapping()
//    public String getAllDepartments(Pageable pageable, Model model){
//        Page<Department> departmentPage = departmentService.getAllDepartment(pageable);
//
//        List<DepartmentDTO> departmentDTOS = modelMapper.map(departmentPage.getContent(), new TypeToken<List<DepartmentDTO>>(){
//        }.getType());
//
//        Page<DepartmentDTO> departmentDTOPage = new PageImpl<>(departmentDTOS, pageable, departmentPage.getTotalElements());
//
//        model.addAttribute("listDepartment", departmentDTOPage);
//
//        return "department-list";
//    }

    @GetMapping
    public String viewListDepartment(Model model){
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public  String findPaginated(@PathVariable (value = "pageNo") Integer pageNo,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDir") String sortDir,
                                 Model model){
        Integer pageSize = 5;
        Page<Department> page = departmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Department> departmentList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : ("asc"));

        model.addAttribute("listDepartment", departmentList);

        return "department-list";
    }

    @GetMapping("/add")
    public String add(){
        return "department-add";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Department department){
        departmentService.save(department);

        return "redirect:/department";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Department department = departmentService.getById(id);
        model.addAttribute("department", department);

        return "department-edit";
    }

    @PostMapping ("/update")
    public String update(@ModelAttribute Department department){
        departmentService.save(department);

        return "redirect:/department";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        departmentService.delete(id);

        return "redirect:/department";
    }

    @RequestMapping("search")
    public String viewSearch(Model model, @Param("keyword") String keyword){
        List<Department> departmentList = departmentService.listAll(keyword);

        model.addAttribute("listDepartment", departmentList);
        model.addAttribute("keyword", keyword);

        return "department-list";
    }
}
