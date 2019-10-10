package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.Spectacle;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {
    
}