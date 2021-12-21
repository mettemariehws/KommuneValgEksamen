package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int party_id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Politican> politicansList;

    public Party(int party_id, String navn, List<Politican> politikkerList) {
        this.party_id = party_id;
        this.name = navn;
        this.politicansList = politikkerList;
    }

    public Party() {

    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Politican> getPoliticansList() {
        return politicansList;
    }

    public void setPoliticansList(List<Politican> politikkerList) {
        this.politicansList = politikkerList;
    }
}
