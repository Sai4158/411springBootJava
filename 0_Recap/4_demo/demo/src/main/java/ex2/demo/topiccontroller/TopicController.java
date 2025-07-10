package ex2.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class TopicController {

//	Auto wired for the topic service 
	@Autowired
	private TopicService topicService;

	
	// gets all the topics 
    @RequestMapping("/topics")
    public List<Topics> getAllTopics() {
        return topicService.getAlltopics();
    }
    
//    Gets topic based on the id
    @RequestMapping("/topics/{id}")
    public Topics getOneTopic(@PathVariable String id) {
        return topicService.getOneTopic(id);
    }
    
    
    // will post a topic
    @PostMapping("/topics")
    public void AddTopic(@RequestBody Topics topic) {
        
        topicService.AddTopic(topic);
    }
    
    // adding delete topic 
    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
    
    
    // Adding put / update by ID 
    
    @PutMapping("topics/{id}")
    public void putMethodName(@PathVariable String id, @RequestBody Topics topic) {
        
    	topicService.updateTopic(id, topic);
    }
    
}
