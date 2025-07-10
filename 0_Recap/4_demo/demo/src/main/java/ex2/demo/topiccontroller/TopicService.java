package ex2.demo.topiccontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TopicService {

	
	private List<Topics> Topics1 =  new ArrayList<>( Arrays.asList(
			new Topics("1", "Java", "Core Java Concepts"),
			new Topics("2", "Spring Boot", "Spring Boot Basics"),
			new Topics("3", "JavaScript", "Frontend Scripting"),
			new Topics("4", "Python", "Data & Scripting"),
			new Topics("5", "SQL", "Database ")
			));

	public List<Topics> getAlltopics(){
		return Topics1;
	}

	public Topics getOneTopic(String id){
		return Topics1.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	
	public void AddTopic(Topics topic){
		Topics1.add(topic); 
	}
	
    public void deleteTopic(String id) {
    	Topics1.removeIf(t -> t.getId().equals(id));
    }
    
    public void updateTopic(String id, Topics topic) {
    	
    	for (int i = 0; i < Topics1.size(); i++) {
			
    		Topics t = Topics1.get(i);
    		
    		if (t.getId().equals(id)) {
    			
    			Topics1.set(i, topic);	
    			
    			return;
    		}
    	}
    }
}
