package com.example.demo.repository;

import com.example.demo.model.Politican;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticianRep extends CrudRepository<Politican, Integer> {
}
