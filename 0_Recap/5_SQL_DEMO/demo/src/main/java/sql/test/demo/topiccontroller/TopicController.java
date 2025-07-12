package sql.test.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topics") // Base path added here
public class TopicController {

    @Autowired
    private TopicService topicService;

    // Get all topics
    @GetMapping
    public List<Topics> getAllTopics() {
        return topicService.getAlltopics();
    }

    // Get one topic by ID
    @GetMapping("/{id}")
    public Topics getOneTopic(@PathVariable String id) {
        return topicService.getOneTopic(id);
    }

    // Create a new topic
    @PostMapping
    public void AddTopic(@RequestBody Topics topic) {
        topicService.AddTopic(topic);
    }

    // Delete a topic by ID
    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    // Update a topic by ID
    @PutMapping("/{id}")
    public void putMethodName(@PathVariable String id, @RequestBody Topics topic) {
        topicService.updateTopic(id, topic);
    }
}
