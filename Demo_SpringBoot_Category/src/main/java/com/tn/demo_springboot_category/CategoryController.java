package com.tn.demo_springboot_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired

    private CategoryRepository categoryRepo;

    @GetMapping("category")
    public List<Category> getAll(){
        List<Category> categories = categoryRepo.findAll();
        categories.forEach(category -> {
            System.out.println(category.getCategoryName());
            System.out.println(category.getDescription());;
        });
        return categories;
    }

    @PostMapping("category/save")
    public String save() {
        Category category1 = new Category(1, "ca111111", "1111111");
        Category category2 = new Category(2 , "ca22222222", "2222222");
        categoryRepo.save(category1);
        categoryRepo.save(category2);
        return "save success";
    }

    @PutMapping("category/update")
    public String update() {
        Category category3 = categoryRepo.findById(2).get();
        category3.setCategoryName("caac");

        categoryRepo.save(category3);

        return "update success";
    }

    @DeleteMapping("category/delete")
    public String delete() {
        Category category4 = categoryRepo.findById(3).get();
        categoryRepo.delete(category4);

        return "delete success";
    }

    @GetMapping("category/{categoryId}")
    public String demopath(@PathVariable String categoryId) {
        System.out.println(categoryId);
        return "ok";
    }

//    @GetMapping("category/{delId}")
//    public String category(@PathVariable Integer delId) {
//        Category category5 = categoryRepo.findById(delId).get();
//        System.out.println(delId);
//        return "ok";
//    }


//    @GetMapping("category/{udId}/{udString}")
//    public String category(@PathVariable Integer udId, @PathVariable String udString) {
//        Category category6 = categoryRepo.findById(udId).get();
//        Category category6 = categoryRepo.findById(udString).get();
//        category6.setId(udId);
//        category6.setId(udString);
//        return "ok";
//    }

//    @GetMapping("demo10")
//    public String demo10(@RequestParam String fullname,
//                         @RequestParam String address) {
//        System.out.println("fullname: " + fullname);
//        System.out.println("address: " + address);
//
//        return "ok";
//    }

//    @PostMapping("signin")
//    public String signin(@PathVariable String username,
//                         @PathVariable String password) {
//        if (username.equals("admin") && password.equals("123456")) {
//            return "dang nhap thanh cong";
//        }
//        return "dang nhap that bai";
//    }

    @PostMapping("demo11")
    public String demo11 (@RequestBody Category obj) {
        categoryRepo.save(obj);

        return "ok";
    }

}
