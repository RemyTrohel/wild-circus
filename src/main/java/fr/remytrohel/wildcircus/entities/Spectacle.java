package fr.remytrohel.wildcircus.entities;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Spectacle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "spectacle", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new TreeSet<Booking>();

    @ManyToMany
    private Set<Performance> performances = new TreeSet<Performance>();
}