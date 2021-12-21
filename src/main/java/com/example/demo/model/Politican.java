package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "politicans")
public class Politican {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int politicans_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @ManyToOne
    //@JsonBackReference(value = "politicans")
    @JoinColumn(name = "party_id", referencedColumnName = "id")
    private Party party;


    public Politican(int politicans_id, String navn, String efternavn, Party parti) {
        this.politicans_id = politicans_id;
        this.name = navn;
        this.lastname = efternavn;
        this.party = parti;
    }

    public Politican() {
    }

    public int getPoliticans_id() {
        return politicans_id;
    }

    public void setPoliticans_id(int politicans_id) {
        this.politicans_id = politicans_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String navn) {
        this.name = navn;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String efternavn) {
        this.lastname = efternavn;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party parti) {
        this.party = parti;
    }
}
