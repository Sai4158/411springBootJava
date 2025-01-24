package psu.ed.myApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


//	Hello world
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
//	Add new end point for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run and havefun";
	}
	
//	Add a end point for fortune
	
	@GetMapping("/Fortune")
	public String getDailyFortune() {
		return "Today is your luckly day";
	}
}
