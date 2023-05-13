package com.tn.controller;


import com.tn.dto.ProductDTO;
import com.tn.entity.Product;
import com.tn.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public List<Product> getAll(){

        return productRepo.findAll();
    }

    @GetMapping("getbyid")
    public ProductDTO getById(){
        Product product = productRepo.findById(2).get();

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;
    }



}
