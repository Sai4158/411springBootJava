package psu.edu.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import psu.edu.thymeleafdemo.entity.Employee;
import psu.edu.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
	private EmployeeService employeeService;
    
	public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    
	// add mapping for "/list"
    
	@GetMapping("/list")
    public String listEmployees(Model theModel) {
        
		// get the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

	    // Save the employee
	    employeeService.save(theEmployee);

	    // Redirect to prevent duplicate submissions
	    return "redirect:/employees/list";
	}

	
}
