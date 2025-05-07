package psu.edu.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/HotelBooking")
    public String showHotelBookingPage() {
        return "hotel-booking";
    }
}
