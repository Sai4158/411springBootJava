package psu.edu.hotelbooking.service;

import java.util.List;
import psu.edu.hotelbooking.entity.Reservation;

public interface ReservationService {
    List<Reservation> findAll();
    Reservation findById(int id);
    Reservation save(Reservation reservation);
    void deleteById(int id);
}
