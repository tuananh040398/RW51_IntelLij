package com.tn.controller;

import com.tn.dto.CategoryDTO;
import com.tn.entity.Category;
import com.tn.repository.CategoryRepository;
import com.tn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAll(Model model){
        List<Category> categories = categoryService.getAll();

        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(obj -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(obj.getId());
            categoryDTO.setCategoryName(obj.getCategoryName());
            categoryDTO.setDescription(obj.getDescription());

            categoryDTOS.add(categoryDTO);
        });

        model.addAttribute("listCategory", categoryDTOS);
        return "category-list";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);

        categoryService.delete(id);
        return "redirect:/category";
    }
}
