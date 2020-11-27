package com.testes.poctest.repositories;

import com.testes.poctest.entities.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {
}
