package com.testes.poctest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parties")
public class PartyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @Column(name = "name", length = 50, columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Column(name = "locale", nullable = false, columnDefinition = "VARCHAR(100)", length = 100)
    private String locale;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partyEntity")
    private List<GuestEntity> guestEntities = new ArrayList<>();

    public void addGuest(final GuestEntity guestEntity) {
        guestEntity.setPartyEntity(this);
        guestEntities.add(guestEntity);
    }
}
