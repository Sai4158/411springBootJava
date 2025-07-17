package psu.edu.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import psu.edu.hotelbooking.dao.ReservationRepository;
import psu.edu.hotelbooking.entity.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Reservation findById(int id) {
        Optional<Reservation> result = reservationRepository.findById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("Reservation ID not found - " + id);
        }
        return result.get();
    }

    @Override
    @Transactional
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
