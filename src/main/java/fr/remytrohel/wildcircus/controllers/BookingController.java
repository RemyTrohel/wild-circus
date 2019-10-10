package fr.remytrohel.wildcircus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.remytrohel.wildcircus.entities.Booking;
import fr.remytrohel.wildcircus.repositories.BookingRepository;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public String calendar() {
        return "booking";
    }

    @GetMapping("/bookings/{id}/edit")
    public String addTicket(Model model, @PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).get();
        model.addAttribute("booking", booking);
        return "ticket";
    }

    @GetMapping("/bookings/{id}")
    public String shoppingCart() {
        return "cart";
    }

    @PostMapping("/bookings")
    public String confirmReservation(@RequestParam Long id) {
        Booking booking = bookingRepository.findById(id).get();
        booking.setConfirmed(true);
        booking = bookingRepository.save(booking);
        return "redirect:/";
    }
}