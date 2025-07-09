package ex2.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
    @RequestMapping("/topics")
    public List<Topics> getAllTopics() {
        return topicService.getAlltopics();
    }
    
    
    @RequestMapping("/topics/{id}")
    public Topics getOneTopic(@PathVariable String id) {
        return topicService.getOneTopic(id);
    }
    
    @PostMapping("/topics")
    public String AddTopic(@RequestBody Topics topic) {
        
        return topicService.AddTopic;
    }
    
    
    
}
