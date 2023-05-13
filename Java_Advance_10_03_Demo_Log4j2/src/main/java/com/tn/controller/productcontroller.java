package com.tn.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class productcontroller {

    @GetMapping("product")
    public String getAll(){
        log.info("Start getting list of products");
        String c = "p";

        try {
            log.info("Start parsing string to int");

            int a = Integer.parseInt(c);
            log.info("Start parsing string to int success!");
        } catch (Exception ex) {
            log.error("Parse string " + c + " to int error");
            log.error(ex);
        }
        return "List Product";
    }
}
