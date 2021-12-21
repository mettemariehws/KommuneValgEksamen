package com.example.demo.controller;

import com.example.demo.model.Party;
import com.example.demo.services.PartyServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    PartyServices partyServices;

    public PartyController(PartyServices partyServices) {
        this.partyServices = partyServices;
    }

    @GetMapping()
    public List<Party> getAllParties(){
        return partyServices.getAllParty();
    }
}
