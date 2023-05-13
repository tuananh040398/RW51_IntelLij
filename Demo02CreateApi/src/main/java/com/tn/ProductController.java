package com.tn;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("product")
    public String abc(){
        return "abcd11111";
    }

    @PostMapping("product/save")
    public String save(){
        return "save success";
    }

    @PutMapping("product/update")
    public String update(){
        return "update success";
    }

    @DeleteMapping("product/delete")
    public String delete(){
        return "delete success";
    }

}
