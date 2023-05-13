package com.tn.service;

import com.tn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepo;

    @Override
    public void updateProductNameByPrice(String productName, Integer price) {
        productRepo.updateProductByPrice(productName, price);
    }

}
