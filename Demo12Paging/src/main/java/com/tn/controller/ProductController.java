package com.tn.controller;

import com.tn.entity.Product;
import com.tn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public Page<Product> getAll(Pageable pageable) {
//        System.out.println(pageable);
        Page<Product> products = productRepo.findAll(pageable);
        return products;
    }
}
