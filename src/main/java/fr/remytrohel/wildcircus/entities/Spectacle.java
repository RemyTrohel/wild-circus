package fr.remytrohel.wildcircus.entities;

import java.sql.Date;
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

    public Spectacle(Long id, Date date, Set<Booking> bookings, Set<Performance> performances) {
        this.id = id;
        this.date = date;
        this.bookings = bookings;
        this.performances = performances;
    }

    public Spectacle(Date date) {
        this.date = date;
    }

    public Spectacle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}