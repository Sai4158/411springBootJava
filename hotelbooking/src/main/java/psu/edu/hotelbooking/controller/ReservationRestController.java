package psu.edu.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import psu.edu.hotelbooking.entity.Reservation;
import psu.edu.hotelbooking.service.ReservationService;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationRestController {  

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService theReservationService) { 
    	this.reservationService = theReservationService;
    }

    // Show all reservations
    @GetMapping("/list")
    public String listReservations(Model theModel) {
        List<Reservation> reservations = reservationService.findAll();
        theModel.addAttribute("reservations", reservations);
        return "reservations/list-reservations";
    }

    // Show form to add new reservation
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Reservation reservation = new Reservation();
        theModel.addAttribute("reservation", reservation);
        return "reservations/reservation-form";
    }

    // Show form to update reservation
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("reservationId") int id, Model theModel) {
        Reservation reservation = reservationService.findById(id);
        theModel.addAttribute("reservation", reservation);
        return "reservations/reservation-form";
    }

    // Save reservation 
    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.save(reservation);
        return "redirect:/reservations/list";
    }

    // Delete reservation
    @GetMapping("/delete")
    public String deleteReservation(@RequestParam("reservationId") int id) {
        reservationService.deleteById(id);
        return "redirect:/reservations/list";
    }
    

}
