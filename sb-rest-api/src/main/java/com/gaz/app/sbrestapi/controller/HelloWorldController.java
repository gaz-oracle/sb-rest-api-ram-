package com.gaz.app.sbrestapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-spring")
    public String helloSpring(){
        return "Hola Spring Boot !!!";
    }
}


