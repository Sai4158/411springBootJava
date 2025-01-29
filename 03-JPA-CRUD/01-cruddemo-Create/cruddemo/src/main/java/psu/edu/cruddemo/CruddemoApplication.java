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

//    @Bean
//    public CommandLineRunner commandLineRunner() { 
//        return runner -> {
//            System.out.println("Welcome to class!!");
//        };
//    }
//    
    
    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDao studentDAO) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Sai", "Rangineeni", "sair@psu.edu");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
