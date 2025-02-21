package psu.edu.CRUD_demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public void updateBookId(int oldId, int newId) {
        employeeDAO.updateBookId(oldId, newId);
    }

    @Override
    @Transactional
    public void deleteByBookId(int bookId) {
        employeeDAO.deleteByBookId(bookId);
    }
}
