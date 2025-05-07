package psu.edu.thymeleafdemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByEmpIdAsc();
}
