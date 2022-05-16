package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Controller {

    @GetMapping("/{id}")
    public String getDetails(@PathVariable("id") String id) {
        if(id.equals("USER_1"))
            return "Gokul";

        throw new RuntimeException();

    }
}
