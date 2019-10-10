package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    
}