package fr.remytrohel.wildcircus.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    private boolean confirmed;

    @ManyToOne
    private Spectacle spectacle;

    @OneToMany
    private Set<Ticket> tickets = new TreeSet<Ticket>();
}