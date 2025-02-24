package psu.edu.CRUD_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psu.edu.CRUD_demo.dao.EmployeeDAO;
import psu.edu.CRUD_demo.entity.Employee;
import psu.edu.CRUD_demo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    
 // add mapping for GET "/employees/{employeeId}
 	@GetMapping("/employees/{employeeId}")
 	public Employee getEmployee(@PathVariable int employeeId) {

 		Employee theEmployee = employeeService.findById(employeeId);
 		
 		if (theEmployee == null) {
 			throw new RuntimeException("Employee id not found -" + employeeId);
 		}
 		
 		return theEmployee;
 	}
 	
 	
// 	Add post 
 	
 	@PostMapping("/employees")
 	public Employee addEmployee(@RequestBody Employee thEmployee) {
 		thEmployee.setId(0);
 		
 		Employee dbEmployee = employeeService.save(thEmployee);
 		
 		return dbEmployee;
 	}
 	
 // PUT "/employees" - Update employee
 	@PutMapping("/employees/{employeeId}")
 	public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee theEmployee) {
 	    Employee existingEmployee = employeeService.findById(employeeId);
 	    
 	    if (existingEmployee == null) {
 	        throw new RuntimeException("Employee id not found - " + employeeId);
 	    }

 	    theEmployee.setId(employeeId); // Ensure correct ID is updated
 	    return employeeService.save(theEmployee);
 	}

    
 // add mapping for DELETE "/employees/{employeeId}" - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found = " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }


  
}