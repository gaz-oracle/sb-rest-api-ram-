package com.gaz.app.sbrestapi.controller;

import com.gaz.app.sbrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * SB REST API WITH REQUEST PARAMERT
     * http://localhost:8080/liststudent/query?id=67 <----QUERY PARAMETER
     */

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

    /** http://localhost:8080/employees?id=555&firstName=Leonel&lastName=Ayala
     * N
     */
    @GetMapping("employees")
    public Student employees(@RequestParam int id,
                                           @RequestParam String firstName,
                                           @RequestParam String lastName){
        return new Student(id,firstName ,lastName);
    }



    /** http://localhost:8080/liststudent/query2?id=1&firstName=John&lastName=Doe
     * Es como básicamente se escribe una API REST de SB para manejar los parámetros
     * de consulta en una URL de solicitud.
     *
     * @PathVariable vs @RequestParam  : PathVariable se utilza para enlazar el valor de la variable
     * de la plantilla URL en el metodo y  la  anotación @RequestParam  para extraer el valor de
     * los parámetros de consulta en una solicitud.
     * */

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
