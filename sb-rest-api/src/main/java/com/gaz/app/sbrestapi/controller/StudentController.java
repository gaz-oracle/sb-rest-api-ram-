package com.gaz.app.sbrestapi.controller;

import com.gaz.app.sbrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Fco", "Gaz");
        return student;
    }
}

/** STEPS:
 * 1. CREATE BEAN STUDENT (MODEL)
 * 2. CREATE CONTROLLER STUDENT
 * 3. CREATE API OF SB on CONTROLLER STUDENT , TO RETURN A JAVA BEAN AS JSON CLIENT
 * siempre que un cliente quiera llamar a esta API, el cliente tiene que usar esta URL, por ejemplo, http:
 * http://localhost:8080/student
 * creacion de la API de Spring Boot que devuelve Java bean como JSON al cliente.
 */