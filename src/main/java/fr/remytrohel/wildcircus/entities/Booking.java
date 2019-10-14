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

    @ManyToOne
    private User user;

    public Booking(Spectacle spectacle, User user) {
        this.price = 0;
        this.spectacle = spectacle;
        this.confirmed = false;
        this.user = user;
    }

    public Booking(Long id, double price, boolean confirmed, Spectacle spectacle, Set<Ticket> tickets, User user) {
        this.id = id;
        this.price = price;
        this.confirmed = confirmed;
        this.spectacle = spectacle;
        this.tickets = tickets;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}