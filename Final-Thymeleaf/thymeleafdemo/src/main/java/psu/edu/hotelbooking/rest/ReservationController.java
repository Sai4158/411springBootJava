package psu.edu.hotelbooking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import psu.edu.hotelbooking.entity.Reservation;
import psu.edu.hotelbooking.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService theReservationService) {
        this.reservationService = theReservationService;
    }

    // GET all reservations
    @GetMapping("/reservations")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    // GET reservation by ID
    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable int reservationId) {
        Reservation reservation = reservationService.findById(reservationId);
        if (reservation == null) {
            throw new RuntimeException("Reservation ID not found - " + reservationId);
        }
        return reservation;
    }

    // POST new reservation
    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        newReservation.setId(0); // Force save of new item
        return reservationService.save(newReservation);
    }

    // PUT update reservation
    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody Reservation updatedReservation) {
        return reservationService.save(updatedReservation);
    }

    // DELETE reservation by ID
    @DeleteMapping("/reservations/{reservationId}")
    public String deleteReservation(@PathVariable int reservationId) {
        Reservation reservation = reservationService.findById(reservationId);
        if (reservation == null) {
            throw new RuntimeException("Reservation ID not found - " + reservationId);
        }
        reservationService.deleteById(reservationId);
        return "Deleted reservation ID - " + reservationId;
    }
}
