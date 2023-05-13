package com.tn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoHttpStatusApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHttpStatusApplication.class, args);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product){
        System.out.println(product);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<?> getById(@RequestParam(required = false) Integer productId){
        System.out.println(productId);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }
}
