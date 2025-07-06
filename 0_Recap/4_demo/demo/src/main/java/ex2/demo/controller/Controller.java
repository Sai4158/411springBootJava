package ex2.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/hi")
	public String getMethodName() {
	    return "Hello";
	}
	
	
}
