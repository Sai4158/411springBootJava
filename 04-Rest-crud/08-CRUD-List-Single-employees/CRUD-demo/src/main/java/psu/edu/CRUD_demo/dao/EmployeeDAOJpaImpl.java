package psu.edu.CRUD_demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import psu.edu.CRUD_demo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

	@Override
	public Employee findById(int theId) {
		
		//get id 
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		
//		Save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
//		return the DbEmployee
		return dbEmployee;
	}

	@Override
	public void deletById(int theId) {

//		find it by Employee id 
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
//		Now remove it
		entityManager.remove(theEmployee);
	}
}
