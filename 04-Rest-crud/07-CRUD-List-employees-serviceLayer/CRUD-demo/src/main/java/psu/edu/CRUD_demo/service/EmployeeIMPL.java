package psu.edu.CRUD_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psu.edu.CRUD_demo.dao.EmployeeDAO;
import psu.edu.CRUD_demo.entity.Employee;

@Service
public class EmployeeIMPL implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeIMPL(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
