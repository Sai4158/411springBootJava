package ex2.demo.topiccontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TopicService {

	public static final String AddTopic = null;
	private List<Topics> Topics1 = Arrays.asList(
			new Topics("1", "Java", "Core Java Concepts"),
			new Topics("2", "Spring Boot", "Spring Boot Basics"),
			new Topics("3", "JavaScript", "Frontend Scripting"),
			new Topics("4", "Python", "Data & Scripting"),
			new Topics("5", "SQL", "Database ")
			);

	public List<Topics> getAlltopics(Topics topic){
		return Topics1;
	}

	public Topics getOneTopic(String id){
		return Topics1.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	
	public void AddTopic(Topics topic){
		Topics1.add(topic); 
	}
	

}
