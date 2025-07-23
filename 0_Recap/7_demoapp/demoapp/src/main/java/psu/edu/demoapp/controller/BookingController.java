package psu.edu.demoapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import psu.edu.demoapp.entity.DogParkBooking;
import psu.edu.demoapp.service.DogParkBookingService;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final DogParkBookingService service;

    public BookingController(DogParkBookingService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model m) {
        m.addAttribute("bookings", service.findAll());
        return "bookings/list-bookings";
    }

    @GetMapping("/new")
    public String showForm(Model m) {
        m.addAttribute("booking", new DogParkBooking());
        return "bookings/booking-form";
    }

    @PostMapping
    public String save(@ModelAttribute DogParkBooking booking,
                       Principal principal) {

        // always use the logged-in account
        booking.setOwnerUsername(principal.getName());

        service.save(booking);          // may still throw “slot full” if over-capacity
        return "redirect:/bookings";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m) {
        m.addAttribute("booking", service.findById(id));
        return "bookings/booking-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/bookings";
    }
}
