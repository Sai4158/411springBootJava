package psu.edu.hotelbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import psu.edu.hotelbooking.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	//	THATS IT FOR THIS CODE
	List<Reservation> findAllByOrderByIdAsc();
}

