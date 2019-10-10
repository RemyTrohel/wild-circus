package fr.remytrohel.wildcircus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.remytrohel.wildcircus.entities.Booking;
import fr.remytrohel.wildcircus.entities.Category;
import fr.remytrohel.wildcircus.entities.Ticket;
import fr.remytrohel.wildcircus.repositories.BookingRepository;
import fr.remytrohel.wildcircus.repositories.TicketRepository;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/tickets")
    public String addTicket(
        @RequestParam int quantity, 
        @RequestParam Category category, 
        @RequestParam Booking booking
    ) {
        Ticket ticket = new Ticket(quantity, booking, category);
        ticket = ticketRepository.save(ticket);
        double newPrice = ticket.getQuantity() * ticket.getCategory().getPrice();
        booking.setPrice(booking.getPrice() + newPrice);
        booking.getTickets().add(ticket);
        booking = bookingRepository.save(booking);
        return "redirect:/bookings/" + booking.getId() + "/edit";
    }
}