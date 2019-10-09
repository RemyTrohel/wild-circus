package fr.remytrohel.wildcircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.remytrohel.wildcircus.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByMail(String mail);
}