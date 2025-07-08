package ex2.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
