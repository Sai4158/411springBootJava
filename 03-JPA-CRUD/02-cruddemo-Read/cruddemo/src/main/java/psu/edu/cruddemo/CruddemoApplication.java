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
//        	We are not creating and we are reading from the db
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
        	
        	readStudent(studentDAO);

        };
    }


//  Will create many student 
    private void createMultipleStudents(StudentDao studentDAO) {
        System.out.println("Creating multiple student objects...");

        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Doe", "jane.doe@example.com");
        Student student3 = new Student("Alice", "Smith", "alice.smith@example.com");

        System.out.println("Saving the students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Saved students. Generated IDs:");
        System.out.println("Student 1 ID: " + student1.getId());
        System.out.println("Student 2 ID: " + student2.getId());
        System.out.println("Student 3 ID: " + student3.getId());
    	
	}

//    Will create one student 
	private void createStudent(StudentDao studentDAO) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Sai1", "Rangineeni2", "sair2@psu.edu");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
