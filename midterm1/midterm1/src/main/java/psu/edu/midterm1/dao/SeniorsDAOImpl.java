package psu.edu.midterm1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PathEditor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import psu.edu.midterm1.entity.Seniors;

@Repository
public class SeniorsDAOImpl  implements SeniorsDAO {
	
	//define fields for entity manager
		private EntityManager entityManager;
		
		//inject entity manager using constructor injection
		@Autowired
		public SeniorsDAOImpl(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
		
		//implementing the save method
		@Override
		@Transactional
		public void store(Seniors theSeniors) {
			entityManager.persist(theSeniors);
		}	

}
