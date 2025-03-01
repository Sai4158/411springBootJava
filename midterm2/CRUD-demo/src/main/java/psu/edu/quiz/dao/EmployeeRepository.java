package psu.edu.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.quiz.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
