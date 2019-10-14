package fr.remytrohel.wildcircus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.remytrohel.wildcircus.entities.Booking;
import fr.remytrohel.wildcircus.entities.Category;
import fr.remytrohel.wildcircus.repositories.BookingRepository;
import fr.remytrohel.wildcircus.repositories.CategoryRepository;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/bookings")
    public String calendar() {
        return "booking";
    }

    @GetMapping("/bookings/{id}/edit")
    public String addTicket(Model model, @PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).get();
        if (booking.isConfirmed()) {
            return "redirect:/bookings";
        }
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("booking", booking);
        model.addAttribute("categories", categories);
        return "ticket";
    }

    @GetMapping("/bookings/{id}")
    public String shoppingCart(Model model, @PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).get();
        if (booking == null) {
            return "redirect:/bookings";
        }
        model.addAttribute("booking", booking);
        return "cart";
    }

    @PostMapping("/bookings")
    public String confirmReservation(Booking booking) {
        booking.setConfirmed(true);
        booking = bookingRepository.save(booking);
        return "redirect:/";
    }
}