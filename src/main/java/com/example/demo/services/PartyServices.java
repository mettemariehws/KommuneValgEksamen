package com.example.demo.services;

import com.example.demo.model.Party;
import com.example.demo.model.Politican;
import com.example.demo.repository.PartyRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServices {

    PartyRep partyRep;

    public PartyServices(PartyRep partyRep) {
        this.partyRep = partyRep;
    }

    public List<Party> getAllParty(){
        List<Party> partyList = new ArrayList<>();
        partyRep.findAll().forEach(partyList::add);
        return partyList;
    }

    public Party getSpecificParty(int id){
        return partyRep.findById(id).get();
    }

}
