package sql.test.demo.topiccontroller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /**
     * FIX: CrudRepository.findAll() returns an Iterable, not a List.
     * Converted the Iterable to a List to match the method's return type.
     */
    public List<Topics> getAllTopics() {
        List<Topics> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    /**
     * FIX: Renamed method from getTopicById to getOneTopic for consistency with the controller's intent.
     * This is an optional style choice, but it improves clarity. The key is consistency.
     */
    public Topics getOneTopic(Long id) {
        return topicRepository.findById(id).orElse(null); // Returns null if not found
    }

    /**
     * FIX: Standardized method name to camelCase (addTopic).
     */
    public Topics addTopic(Topics topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

}