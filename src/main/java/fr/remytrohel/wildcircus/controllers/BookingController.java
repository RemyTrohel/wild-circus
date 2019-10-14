package fr.remytrohel.wildcircus.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.remytrohel.wildcircus.entities.Booking;
import fr.remytrohel.wildcircus.entities.Category;
import fr.remytrohel.wildcircus.entities.Ticket;
import fr.remytrohel.wildcircus.entities.User;
import fr.remytrohel.wildcircus.repositories.BookingRepository;
import fr.remytrohel.wildcircus.repositories.CategoryRepository;
import fr.remytrohel.wildcircus.repositories.UserRepository;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/bookings")
    public String calendar(Authentication authentication, Model model) {
        Long userId = ((User)authentication.getPrincipal()).getId();
        User user = userRepository.findById(userId).get();
        if (!user.getBookings().isEmpty()) {
            model.addAttribute("bookings", user.getBookings());
        }
        return "booking";
    }

    @GetMapping("/bookings/{id}/edit")
    public String addTicket(Model model, @PathVariable Long id) {
        Booking booking = bookingRepository.findById(id).get();
        if (booking.isConfirmed()) {
            return "redirect:/bookings";
        }
        List<Category> categories = categoryRepository.findAll();
        Set<Ticket> tickets = booking.getTickets();
        model.addAttribute("booking", booking);
        model.addAttribute("tickets", tickets);
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