package com.gaz.app.sbrestapi.controller;

import com.gaz.app.sbrestapi.bean.Student;
import jdk.jfr.Percentage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                100,
                "Fco",
                "Gaz"
        );
        // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "App.com")
                .body(student);
    }


    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Fco", "Gaz"));
        students.add(new Student(2, "Leo", "Moro"));
        students.add(new Student(3, "Isa", "Gaz Moro"));;
        return ResponseEntity.ok(students);
    }

    //http://localhost:8080/students/1/Gaz/App
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName,
                                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    //  http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("/students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
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
 * SB REST API that handles HTTP POST Request -> CREATING NEW RESOURCES
 * // @PostMapping and @RequestBody
 */

// Spring boot REST API that handles HTTP POST Request - creating new resource
// @PostMapping and @RequestBody
@PostMapping("create")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<Student> createStudent(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
}
/**
 * PUT UPDATE A RESOURCE
 * SB - CREATE REST API THE HANDLES HTTP PU REQUEST -> UPDATING EXISTING RESOURCE
 */
@PutMapping("{id}/update")
public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return ResponseEntity.ok(student);
}

    /**
     * Cada vez que el cliente realiza una solicitud de eleminación HTTP, el cliente tiene que enviar
     * un metodo HTTP de eliminaccion en la solicitud.
     * El cliente no tiene que enviar ningun dato en el cuerpo de la solicitud, solo el id del  Item a eliminar.
     *
     * SB REST API that handles HTTP DELETE Request - deleting the existing resource.
     */
    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    /**
     * ResponseEntity: es una clase muy util para crear una respuesta HTTP completa
     * para SB API REST
     *
     * 1. ResponseEntity: Representa todo un conjunto de respuestas HTTP compeltas.
     *  como codigo de estado, encabezados y cuerpo, como resultado podemos usarlos
     *  para configurar la Respuesta HTTP.
     *  Normalmente se prefiere para utilzar una respuesta.
     *
     *  2.Si queremos usar esto, tenemos que retornar desde el endpoit y SB se encargara del resto
     *  Nuestra API tiene que delvorver una instancia de la clase ResponseEntity y SB se
     *  encargara del resto. SB creara isntancias de esta clase ResponseEntity en la INSTANCIA HTTP.
     *
     *  3.ResponseEntity es generica  por lo que podemos pasar cualquier tipo de clase generica ResponseEntity.
     *
     */

}

