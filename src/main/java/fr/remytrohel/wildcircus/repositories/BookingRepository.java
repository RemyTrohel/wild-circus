package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}