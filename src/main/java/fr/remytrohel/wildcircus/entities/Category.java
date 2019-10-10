package fr.remytrohel.wildcircus.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new TreeSet<Ticket>();

    public Category(Long id, String name, Set<Ticket> tickets, double price) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
        this.price = price;
    }

    public Category() {
    }

    public Category(String name, Set<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
        this.price = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}