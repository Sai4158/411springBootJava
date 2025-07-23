package psu.edu.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // GET  /login  →  templates/login.html
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
