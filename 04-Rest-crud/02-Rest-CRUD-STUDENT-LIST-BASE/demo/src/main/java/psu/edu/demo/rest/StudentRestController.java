package psu.edu.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psu.edu.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students") 
    public List<Student> getStudents() {

        List<Student> theStudents = new ArrayList<>(); 
        
        // Adding sample students
        theStudents.add(new Student("Dany", "Mascher"));
        theStudents.add(new Student("David", "Masch"));
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Smith"));

        return theStudents; 
    }
}
