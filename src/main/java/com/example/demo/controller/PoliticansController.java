package com.example.demo.controller;

import com.example.demo.model.Politican;
import com.example.demo.services.PoliticanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pol")
public class PoliticansController {

    PoliticanService politicanService;

    public PoliticansController(PoliticanService politikkerService) {
        this.politicanService = politikkerService;
    }

    @GetMapping()
    public List<Politican> getAllPoliticans(){
        return politicanService.getAllPoliticans();
    }

    @PostMapping()
    public ResponseEntity<Politican> createPol(@RequestBody Politican pol){
        politicanService.addPolitican(pol);
        return ResponseEntity.status(HttpStatus.OK).body(pol);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Politican> updatePolInfo(@RequestBody Politican pol) {
        politicanService.updatePolitican(pol);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Politican> deletepol(@PathVariable("id") int id){
        politicanService.deletePoliticans(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public List<Politican> getPolFromSpecificParty(@PathVariable("id") int id){
        return politicanService.getPolForSpecificParty(id);
    }
}
