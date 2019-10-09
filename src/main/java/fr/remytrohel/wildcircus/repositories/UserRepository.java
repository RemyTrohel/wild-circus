package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.remytrohel.wildcircus.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}