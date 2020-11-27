package com.testes.poctest.repositories;

import com.testes.poctest.entities.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer> {
}
