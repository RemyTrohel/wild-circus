package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.Category;;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}