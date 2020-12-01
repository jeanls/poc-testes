package com.testes.poctest.repositories;

import com.testes.poctest.entities.PartyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PartyRepository extends JpaRepository<PartyEntity, Integer> {

    @Query("from PartyEntity p where p.name like %:search% order by p.name desc")
    Page<PartyEntity> index(@Param("search") final String search, final Pageable pageable);
}
