package psu.ed.my_first_task.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstTaskController {
    @Value("${custom.name}")
    private String name;

    @Value("${custom.major}")
    private String major;

    @Value("${custom.hobby}")
    private String hobby;

    // Default endpoint
    @GetMapping("/")
    public String welcome() {
        return "Welcome to PSU";
    }

    // Game endpoint
    @GetMapping("/game")
    public String game() {
        return "PSU Won the GAME!!";
    }

    // Play endpoint
    @GetMapping("/play")
    public String play() {
        return "The Play is OFF!!";
    }

    // Custom properties endpoint
    @GetMapping("/custom")
    public String customInfo() {
        return "Name: " + name + ", Major: " + major + ", Hobby: " + hobby;
    }
}
