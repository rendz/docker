package com.epam.simple_service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fortune {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String fortune;

    public Fortune() {
    }

    public Fortune(String fortune) {
        this.fortune = fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public String getFortune() {
        return fortune;
    }
}
