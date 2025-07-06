package ex2.demo.topiccontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class TopicController {

    @GetMapping("/topics")
    public List<Topics> getAllTopics() {
        return Arrays.asList(
            new Topics("1", "Java", "Core Java Concepts"),
            new Topics("2", "Spring Boot", "Spring Boot Basics"),
            new Topics("3", "JavaScript", "Frontend Scripting"),
            new Topics("4", "Python", "Data & Scripting"),
            new Topics("5", "SQL", "Database Queries")
        );
    }
}
