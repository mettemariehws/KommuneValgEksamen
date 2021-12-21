package com.example.demo.repository;

import com.example.demo.model.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRep extends CrudRepository<Vote, Integer> {
}
