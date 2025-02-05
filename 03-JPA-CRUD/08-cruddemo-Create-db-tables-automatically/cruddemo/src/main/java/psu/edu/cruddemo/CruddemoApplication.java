package psu.edu.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import psu.edu.cruddemo.dao.StudentDao;
import psu.edu.cruddemo.entity.Student;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDAO) {
        return runner -> {
            // Uncomment one of these to test each method
             createStudent(studentDAO);
             createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//        	updateStudent(studentDAO);
//        	deleteStudent(studentDAO);
//        	deleteAllStudents(studentDAO);

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
    
    
//    
//    public void deleteAllStudents(StudentDao studentDAO) {
//        System.out.println("Deleting all students...");
//        
//        int numberOfRowsDeleted = studentDAO.deleteAll();  // Get count of deleted students
//
//        System.out.println("Deleted " + numberOfRowsDeleted + " students from database.");
//    }
//
//    
//    private void deleteStudent(StudentDao studentDAO) {
//        int studentID = 3;
//
//        System.out.println("Deleting student with id: " + studentID);
//
//        studentDAO.delete(studentID);
//    }

    
//    private void updateStudent(StudentDao studentDAO) {
////    get student based on the id: primary key 
//    	int studentid = 1;
//    	System.out.println("Getting student with i: " + studentid);
//    	Student myStudent =  studentDAO.findById(studentid);
//    	
////    	change the first name to "Uday"
//    	System.out.println("Updating student... " + studentid);
//    	
//    	myStudent.setFirstName("Uday");
//    	
////    	Update the student
//    	studentDAO.update(myStudent);
//    	
////    	Display the updated student
//    	System.out.println("Updated student with id: studentId");
//
//    	
//    	
//    	}
    
//    private void queryForStudentsByLastName(StudentDao studentDAO) {
//        String lastName = "Rangineeni";  
//        System.out.println("Retrieving students with last name: " + lastName);
//
//        List<Student> theStudents = studentDAO.findByLastName(lastName);
//
//        // Display students
//        for (Student tempStudent : theStudents) {
//            System.out.println(tempStudent);
//        }
//    }

//    private void queryForStudents(StudentDao studentDAO) {
//        // Get a list of students
//        List<Student> theStudents = studentDAO.findAll(); 
//
//        // Display list of students
//        for (Student tempStudent : theStudents) {
//            System.out.println(tempStudent);
//        }
//    }
//
//    private void readStudent(StudentDao studentDAO) {
//        // Create a new student object
//        System.out.println("Creating new student object...");
//        Student tempStudent = new Student("Kyle", "Hay", "k.hay@psu.edu");
//
//        // Save the student object
//        System.out.println("Saving the student...");
//        studentDAO.save(tempStudent);
//
//        // Display ID of the saved student
//        int theId = tempStudent.getId();
//        System.out.println("Saved student. Generated ID: " + theId);
//
//        // Retrieve student based on ID: primary key
//        System.out.println("Retrieving student with ID: " + theId);
//        Student myStudent = studentDAO.findById(theId);
//
//        // Display retrieved student
//        System.out.println("Found the student: " + myStudent);
//    }
}
