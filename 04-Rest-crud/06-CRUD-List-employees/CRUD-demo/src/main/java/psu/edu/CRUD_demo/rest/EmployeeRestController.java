package psu.edu.CRUD_demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psu.edu.CRUD_demo.dao.EmployeeDAO;
import psu.edu.CRUD_demo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() { // 
        return employeeDAO.findAll();
    }
}
