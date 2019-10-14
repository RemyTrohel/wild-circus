package fr.remytrohel.wildcircus.controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import fr.remytrohel.wildcircus.entities.Booking;
import fr.remytrohel.wildcircus.entities.Performance;
import fr.remytrohel.wildcircus.entities.Spectacle;
import fr.remytrohel.wildcircus.entities.User;
import fr.remytrohel.wildcircus.repositories.BookingRepository;
import fr.remytrohel.wildcircus.repositories.PerformanceRepository;
import fr.remytrohel.wildcircus.repositories.SpectacleRepository;

@Controller
public class SpectacleController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SpectacleRepository spectacleRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @PostMapping("/spectacle")
    public String createSpectacle(Date date, Authentication authentication) {
        Spectacle spectacle = spectacleRepository.findByDate(date);
        if (spectacle == null) {
            Set<Performance> performances = new HashSet<Performance>(performanceRepository.findAll());
            spectacle = new Spectacle(date);
            spectacle = spectacleRepository.save(spectacle);
            spectacle.setPerformances(performances);
            spectacle = spectacleRepository.save(spectacle);
        }
        User user = (User)authentication.getPrincipal();
        Booking booking = new Booking(spectacle, user);
        booking = bookingRepository.save(booking);
        return "redirect:/bookings/" + booking.getId() + "/edit";
    }
}