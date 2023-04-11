package com.gaz.app.sbrestapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    /**
     * HTTP GET REQUEST
     *  localhost:8080/hello-spring
     *  La api rest devuelve la cadena: "Hola Spring Boot"
     */
    @GetMapping("/hello-spring")
    public String helloSpring(){
        return "Hola Spring Boot !!!";
    }
}

/**
 *@Controller:
 *  Se utiliza para marcar una clase como controlador de solicitudes web
 *  Se usa principalmente con aplicaciones Spring MVC
 *  @ResponseBody:
 *  le dice a un controlador que el objeto devuelto se serializa automáticamente
 *  en JSON y se vuelve a pasar al objeto HttpResponse
 *
 *  @Controller + @ResponseBody = @RestController
 */
