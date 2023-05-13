package com.tn.controller;

import com.tn.entity.Product;
import com.tn.repository.ProductRepository;
import com.tn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductService productService;

//    @GetMapping
//    public ResponseEntity<?> getAll() {
//        List<Product> products = productRepo.findAll();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
////    findByProductName
//    @GetMapping("getByProductName")
//    public ResponseEntity<?> getByProductName(@RequestParam String productName) {
//        List<Product> products = productRepo.findByProductName(productName);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
////    @GetMapping("getByProductName") @Path
//    @GetMapping("getByProductName2/{productId}")
//    public ResponseEntity<?> getByProductId(@PathVariable Integer productId) {
//        List<Product> products = productRepo.findByProductId(productId);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }

//    @GetMapping("getByProductName") @RequestBody

//    GetAll
//    @GetMapping
//    public List<Product> getAll() {
//        List<Product> products = productRepo.findAll();
//        products.forEach(product -> {
//            System.out.println(product.getProductName());
//            System.out.println(product.getPrice());
//        });
//        return products;
//    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Product> products = productRepo.getAllData2();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("getByName")
    public ResponseEntity<?> getByName(){
        List<Product> products = productRepo.getAllByName2();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("getByName3")
    public ResponseEntity<?> getByName3(@RequestParam String pProductName){
        List<Product> products = productRepo.getAllByName3(pProductName);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("getByName4")
    public ResponseEntity<?> getByNamePrice(@RequestParam String pProductName,
                                            @RequestParam Integer pPrice) {
        List<Product> products = productRepo.getAllByName4(pProductName, pPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        productRepo.deleteById(id);
        return new ResponseEntity<>("Delete successfull", HttpStatus.OK);
    }

    @Transactional
    @PutMapping("updateProductById/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Integer id){
        productRepo.updateProductById(id);
        return new ResponseEntity<>("Update successfull", HttpStatus.OK);
    }
}
