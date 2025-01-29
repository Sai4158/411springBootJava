package psu.edu.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import psu.edu.cruddemo.dao.StudentDao;
import psu.edu.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDAO) {
        return runner -> {
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDao studentDAO) {
        // Create a new student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Kyle", "Hay", "k.hay@psu.edu");

        // Save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // Display ID of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated ID: " + theId);

        // Retrieve student based on ID: primary key
        System.out.println("Retrieving student with ID: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // Display retrieved student
        System.out.println("Found the student: " + myStudent);
    }
}
