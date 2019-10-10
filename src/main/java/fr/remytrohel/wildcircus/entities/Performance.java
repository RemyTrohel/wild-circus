package fr.remytrohel.wildcircus.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Performance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500)
    private String description;
    
    private String artist;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Spectacle> spectacles = new TreeSet<Spectacle>();

    public Performance(Long id, String name, String description, String artist) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.artist = artist;
    }

    public Performance(String name, String description, String artist) {
        this.name = name;
        this.description = description;
        this.artist = artist;
    }

    public Performance() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}