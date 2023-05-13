package com.tn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

//    @GetMapping("product")
//    public List<Product> abc(){
//        List<Product> products = productRepo.findAll();
//        products.forEach(product -> {
//            System.out.println(product.getProductName());
//        });
//        return products;
//    }

    @PostMapping("product")
    public String save() {
        Product product1 = new Product();
        product1.setProductName("VipPro");
        productRepo.save(product1);

        return "save success";
    }

}
