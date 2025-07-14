package sql.test.demo.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * FIX: Corrected the service method call from "getAlltopics" to "getAllTopics".
     */
    @GetMapping
    public List<Topics> getAllTopics() {
        return topicService.getAllTopics();
    }

    /**
     * FIX: Corrected the service method call from "getOneTopic" to the actual method name "getOneTopic".
     */
    @GetMapping("/{id}")
    public Topics getOneTopic(@PathVariable Long id) {
        return topicService.getOneTopic(id);
    }

    /**
     * FIX: Renamed method to "addTopic" (camelCase convention) and
     * corrected the service method call from "AddTopic" to "addTopic".
     */
    @PostMapping
    public void addTopic(@RequestBody Topics topic) {
        topicService.addTopic(topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }


}