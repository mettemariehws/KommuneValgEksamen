package com.example.demo.services;

import com.example.demo.model.Politican;
import com.example.demo.repository.PoliticianRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoliticanService {

    PoliticianRep politikkerRep;
    PartyServices partyService;

    public PoliticanService(PoliticianRep politikkerRep, PartyServices partyService) {
        this.politikkerRep = politikkerRep;
        this.partyService = partyService;
    }

    public List<Politican> getAllPoliticans(){
        List<Politican> polList = new ArrayList<>();
        politikkerRep.findAll().forEach(polList::add);
        return polList;
    }

    public void deletePoliticans(int id){
        politikkerRep.deleteById(id);
    }

    public void addPolitican(Politican pol){
        politikkerRep.save(pol);
    }

    public Politican getSpecificPolitican(int id){
        return politikkerRep.findById(id).get();
    }

    public void updatePolitican(Politican pol){
        politikkerRep.save(pol);
    }

    public List<Politican> getPolForSpecificParty(int id){
        List<Politican> polFromTheParty = partyService.getSpecificParty(id).getPoliticansList();
        return polFromTheParty;
    }

}
