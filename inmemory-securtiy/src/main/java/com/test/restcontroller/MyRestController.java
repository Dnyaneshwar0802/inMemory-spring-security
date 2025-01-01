package com.test.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/secure")
    public String securedAPI(){
        return "SECURED API ACCESSED";
    }
}
