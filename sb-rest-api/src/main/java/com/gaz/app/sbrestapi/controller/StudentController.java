package com.gaz.app.sbrestapi.controller;

import com.gaz.app.sbrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Fco", "Gaz");
        return student;
    }
    @GetMapping("/liststudent")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Fco", "Gaz"));
        students.add(new Student(2, "Leo", "Moro"));
        students.add(new Student(3, "Isa", "Gaz Moro"));
        return students;
    }

    //http://localhost:8080/liststudent2/1
    @GetMapping("/liststudent2/{id}")
    public Student studentPathVariable2(@PathVariable("id") int studentid){
        return new Student(studentid, "Gaz", "Spring");
    }
    //http://localhost:8080/liststudent/555/Gaz/App
    @GetMapping("/liststudent/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int liststudentid,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(liststudentid, firstName, lastName);
    }

    @GetMapping("liststudent/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "John", "DoE");
    }

    @GetMapping("liststudent/query2")
    public Student studentRequestVariable2(@RequestParam int id,
                                           @RequestParam String firstName,
                                           @RequestParam String lastName){
        return new Student(id,firstName ,lastName);
    }

    @GetMapping("employees")
    public Student employees(@RequestParam int id,
                                           @RequestParam String firstName,
                                           @RequestParam String lastName){
        return new Student(id,firstName ,lastName);
    }

/**
 * SB REST API that handles HTTP POST Request
 * // @PostMapping and @RequestBody
 */

@PostMapping("create")
@ResponseStatus(HttpStatus.CREATED) // ok
public Student StudentController(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return student;
   // return new ResponseEntity<>(student, HttpStatus.CREATED);
}

}

