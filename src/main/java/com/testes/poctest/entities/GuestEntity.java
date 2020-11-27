package com.testes.poctest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "INTEGER")
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @JoinColumn(name = "party_id", columnDefinition = "INTEGER", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PartyEntity partyEntity;

    @Column(name = "entry_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime entryAt;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)", length = 15, nullable = false)
    private String phone;
}
