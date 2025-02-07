package psu.edu.midterm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import psu.edu.midterm1.dao.SeniorsDAO;
//import 
import psu.edu.midterm1.entity.Seniors;

@SpringBootApplication
public class Midterm1Application {

	public static void main(String[] args) {
		SpringApplication.run(Midterm1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(SeniorsDAO seniorsDAO) {
		return runner -> {
			createMultipleSeniors(seniorsDAO); 			
		};
	}
	
	private void createMultipleSeniors(SeniorsDAO seniorsDAO) {
		//Create a seniors object
		System.out.println("Creating 2 senior object... ");
		Seniors tempSenior1 = new Seniors("IST 411", "Distributed Computing", "Prof. Lomotey");
		Seniors tempSenior2 = new Seniors("IST 454", "DIgital Forensics", "Prof. Andy John");
				
		//save the student objects
		System.out.println("Saving the seniors... ");
		seniorsDAO.store(tempSenior1);
		seniorsDAO.store(tempSenior2);
	}

}
