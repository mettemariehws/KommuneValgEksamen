package com.example.demo.controller;

import com.example.demo.model.Vote;
import com.example.demo.services.VoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping()
    public List<Vote> getAllvotes(){
       return voteService.getAllVotes();
    }
}
