package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "votes")
    private double votes;

    @Column(name = "party")
    private String partyName;

    public Vote() {

    }

    public Vote(int id, double procentages, String partyName) {
        this.id = id;
        this.votes = procentages;
        this.partyName = partyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
