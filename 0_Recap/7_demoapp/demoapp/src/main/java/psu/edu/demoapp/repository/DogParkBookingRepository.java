package psu.edu.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import psu.edu.demoapp.entity.DogParkBooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DogParkBookingRepository
        extends JpaRepository<DogParkBooking, Integer> {

    long countBySlotDateAndSlotStartAndSlotEnd(
            LocalDate slotDate, LocalTime slotStart, LocalTime slotEnd);

    List<DogParkBooking> findByOwnerUsername(String ownerUsername);
}
