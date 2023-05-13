package com.huytien.controller;

import com.huytien.dto.entitydto.DepartmentDTO;
import com.huytien.entity.Account;
import com.huytien.entity.Department;
import com.huytien.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/departments")
@Log4j2
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public String viewListDepartment(Model model){
        return findPaginated(1, "name", "asc", model);
    }

//    @GetMapping()
//    public String getAllDepartments(Pageable pageable,
//                                    @RequestParam(required = false) String search,
//                                    Model model){
//        Page<Department> departmentPage = departmentService.getAllDepartments(pageable, search);
//
//        List<DepartmentDTO> departmentDTOS = modelMapper.map(departmentPage.getContent(), new TypeToken<List<DepartmentDTO>>() {}.getType());

//        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
//        for (Department department: departmentPage.getContent()){
//            DepartmentDTO departmentDTO = new DepartmentDTO();
//            departmentDTO.setId(department.getId());
//            departmentDTO.setName(department.getName());
//            departmentDTOS.add(departmentDTO);
//        }

//        Page<DepartmentDTO> departmentDTOPage = new PageImpl<>(departmentDTOS, pageable, departmentPage.getTotalElements());
//
//        model.addAttribute("listDepartment", departmentDTOPage);
//
//        return "list-department";
//    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") Integer pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
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

        return "list-department";
    }

    @GetMapping("/add")
    public String saveForm(){
        return "department-creating";
    }

    @PostMapping("/creating")
    public String save(Department department){
        departmentService.creatingDepartment(department);
        return "redirect:/api/v1/departments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model){
        model.addAttribute("department", departmentService.findById(id));
        return "department-edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Department department){
        departmentService.updateDepartmentById(department);
        return "redirect:/api/v1/departments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/api/v1/departments";
    }



}
