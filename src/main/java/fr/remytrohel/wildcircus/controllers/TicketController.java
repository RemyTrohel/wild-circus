package fr.remytrohel.wildcircus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import fr.remytrohel.wildcircus.entities.Booking;
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
    public String addTicket(Ticket ticket) {
        ticket = ticketRepository.save(ticket);
        Booking booking = ticket.getBooking();
        double newPrice = ticket.getQuantity() * ticket.getCategory().getPrice();
        booking.setPrice(booking.getPrice() + newPrice);
        booking = bookingRepository.save(booking);
        return "redirect:/booking/" + booking.getId() + "/edit";
    }
}