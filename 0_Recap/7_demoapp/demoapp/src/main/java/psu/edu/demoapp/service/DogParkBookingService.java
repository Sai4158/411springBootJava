package psu.edu.demoapp.service;

import psu.edu.demoapp.entity.DogParkBooking;

import java.util.List;

public interface DogParkBookingService {

    List<DogParkBooking> findAll();

    DogParkBooking findById(Integer id);

    DogParkBooking save(DogParkBooking booking);

    void deleteById(Integer id);
}
