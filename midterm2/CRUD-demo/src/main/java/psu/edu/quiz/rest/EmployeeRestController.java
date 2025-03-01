package psu.edu.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import psu.edu.quiz.entity.Employee;
import psu.edu.quiz.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // GET all employees
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET employee by ID
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        return theEmployee;
    }

    // POST - Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0); 
        return employeeService.save(theEmployee);
    }

    // PUT - Update existing employee
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee theEmployee) {
        Employee existingEmployee = employeeService.findById(employeeId);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee ID not found - " + employeeId);
        }
        theEmployee.setId(employeeId);
        return employeeService.save(theEmployee);
    }

    // DELETE - Remove employee by ID
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee ID not found = " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee ID - " + employeeId;
    }
}
