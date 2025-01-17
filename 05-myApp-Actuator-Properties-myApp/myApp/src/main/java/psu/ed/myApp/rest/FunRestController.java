package psu.ed.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
//	INJECT properties for school.name, campus.location, campues.name
	
	@Value("${school.name}")
	private String SchoolName;
	
	@Value("${campus.name}")
	private String CampusName;
	
	@Value("${campus.location}")
	private String CampusLocation;

	
//	End point for the school name
	@GetMapping("/School")
	public String getSchoolName() {
		return "School: " + SchoolName + ", Campus: " + CampusName + ", CampusLocation: " + CampusLocation;
	}
	
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
