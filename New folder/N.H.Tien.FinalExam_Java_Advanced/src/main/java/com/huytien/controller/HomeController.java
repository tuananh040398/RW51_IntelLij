package com.huytien.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/login?logout")
    public String logOut(){
        return "home";
    }
}
