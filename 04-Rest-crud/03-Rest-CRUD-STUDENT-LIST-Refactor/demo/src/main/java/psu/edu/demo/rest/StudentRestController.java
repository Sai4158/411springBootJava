package psu.edu.demo.rest;

import java.util.List;
import java.util.ArrayList; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import psu.edu.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Dany", "Mascher"));
        theStudents.add(new Student("David", "Masch"));
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
}
