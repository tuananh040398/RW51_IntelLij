package com.tn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/")
    public String home(){

        return "trang-chu";
    }

    @GetMapping("product")
    public String getAll(){

        return "product-list";
    }

    @GetMapping("product-add")
    public String add(){

        return "product-add";
    }
}
