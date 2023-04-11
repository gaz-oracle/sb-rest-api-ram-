package com.gaz.app.sbrestapi.controller;

import com.gaz.app.sbrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        students.add(new Student(1, "Isa", "Gaz Moro"));
        return students;
    }
    /**
     * 1.Sprin Boot REST Api with Path Variable
     * 2. {id} - URI template variable
     * 3. http://localhost:8080/liststudent/1"
     * 4. la Url contiene, una variable y para obtener esta variable se utiliza la anoatccion: @PathVariable("id")
     * 5. Se pueden pasar multiples variables de Path*/
    /**
     *  @GetMapping("/liststudent/{id}")
     *     public Student studentPathVariable(@PathVariable("id") int liststudentid){
     *         return new Student(liststudentid, "Ram", "Fadatare");
     *     }
     */

    @GetMapping("/liststudent/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int liststudentid,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(liststudentid, firstName, lastName);
    }

}

