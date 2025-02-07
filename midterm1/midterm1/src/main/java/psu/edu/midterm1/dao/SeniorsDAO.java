package psu.edu.midterm1.dao;

import org.springframework.transaction.annotation.Transactional;

import psu.edu.midterm1.entity.Seniors;

public interface SeniorsDAO {
	@Transactional
    void store(Seniors theSeniors);

}
