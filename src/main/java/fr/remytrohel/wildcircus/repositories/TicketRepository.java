package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}