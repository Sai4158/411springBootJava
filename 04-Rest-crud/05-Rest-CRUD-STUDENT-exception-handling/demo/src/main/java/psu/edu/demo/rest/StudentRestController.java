package psu.edu.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import psu.edu.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents = new ArrayList<>(); 

	
	@PostConstruct
	public void loadData() {        
        // Adding sample students
        theStudents.add(new Student("Dany", "Mascher"));
        theStudents.add(new Student("David", "Masch"));
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Smith"));
	}
	
    @GetMapping("/students") 
    public List<Student> getStudents() {


        return theStudents; 
    }
    
//    define end for /students/{studentid}
    @GetMapping("/students/{studentId}") 
    public Student getStudents(@PathVariable int studentId) {

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
    	
        return theStudents.get(studentId); 
    }
    
    //exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
    
    	  // Create StudentErrorResponse object
        StudentErrorResponse error = new StudentErrorResponse();
        
        // Set error details
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // Return ResponseEntity with error object and HTTP status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    
    }
//    
}
