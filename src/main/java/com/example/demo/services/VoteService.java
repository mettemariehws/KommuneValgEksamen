package com.example.demo.services;

import com.example.demo.model.Vote;
import com.example.demo.repository.VoteRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    VoteRep voteRep;

    public VoteService(VoteRep voteRep) {
        this.voteRep = voteRep;
    }

    public List<Vote> getAllVotes(){
        List<Vote> allVotesList = new ArrayList<>();
        voteRep.findAll().forEach(allVotesList::add);
        return allVotesList;
    }
}
