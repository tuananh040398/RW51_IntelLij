package com.tn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/")
    public String home(){

        return "trang-chu";
    }

    @GetMapping("admin/product/list")
    public String getAll(){

        return "product-list";
    }

    @GetMapping("admin/product-add")
    public String add(){

        return "product-add";
    }
    @GetMapping("admin/product-edit")
    public String edit(){

        return "product-add";
    }
}
