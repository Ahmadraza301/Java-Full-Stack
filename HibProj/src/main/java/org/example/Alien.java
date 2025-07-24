package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aliens")  // Added explicit table name
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Added ID generation strategy
    @Column(name = "alien_id")
    private int aid;

    @Column(name = "alien_name", length = 100, nullable = false)
    private String aname;

    @Column(name = "technology", length = 50)
    private String tech;

    // Required no-arg constructor
    public Alien() {
    }

    // Getters and setters
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}