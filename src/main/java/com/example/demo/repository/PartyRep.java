package com.example.demo.repository;

import com.example.demo.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRep extends CrudRepository<Party, Integer> {
}
