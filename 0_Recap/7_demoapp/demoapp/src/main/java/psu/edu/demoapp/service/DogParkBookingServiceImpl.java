package psu.edu.demoapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psu.edu.demoapp.entity.DogParkBooking;
import psu.edu.demoapp.repository.DogParkBookingRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DogParkBookingServiceImpl implements DogParkBookingService {

    private static final int MAX_DOGS_PER_SLOT = 10;   

    private final DogParkBookingRepository repo;

    public DogParkBookingServiceImpl(DogParkBookingRepository repo) {
        this.repo = repo;
    }

    @Override public List<DogParkBooking> findAll() { return repo.findAll(); }

    @Override public DogParkBooking findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DogParkBooking save(DogParkBooking b) {
        // capacity check
        LocalDate d = b.getSlotDate();
        LocalTime s = b.getSlotStart();
        LocalTime e = b.getSlotEnd();
        
        long booked = repo.countBySlotDateAndSlotStartAndSlotEnd(d, s, e);
        
        if (booked >= MAX_DOGS_PER_SLOT)
            throw new IllegalStateException("Sorry, that slot is full.");

        return repo.save(b);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) { repo.deleteById(id); }
}
