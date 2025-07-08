package ex2.demo.topiccontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topics> Topics1 = Arrays.asList(
            new Topics("1", "Java", "Core Java Concepts"),
            new Topics("2", "Spring Boot", "Spring Boot Basics"),
            new Topics("3", "JavaScript", "Frontend Scripting"),
            new Topics("4", "Python", "Data & Scripting"),
            new Topics("5", "SQL", "Database ")
        );
	
	
	public List<Topics> getAlltopics(){
		return Topics1;
	}
	
}
