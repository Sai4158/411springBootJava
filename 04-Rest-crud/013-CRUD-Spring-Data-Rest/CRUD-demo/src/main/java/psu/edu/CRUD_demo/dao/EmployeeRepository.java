package psu.edu.CRUD_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.CRUD_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
