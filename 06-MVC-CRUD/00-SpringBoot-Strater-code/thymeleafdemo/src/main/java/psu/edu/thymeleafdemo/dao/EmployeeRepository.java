package psu.edu.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psu.edu.thymeleafdemo.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

//	THATS IT FOR THIS CODE

}
