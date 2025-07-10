package org.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Data
@AllArgsConstructor
@Getter
@Entity
@Table(name="ProgramObrazovanja")

public class ProgramObrazovanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProgramObrazovanjaId")
    private int idProgObr;

    @Column(name="Naziv")
    private String naziv;

    @Column(name="CSVET")
    private int csvet;

    public ProgramObrazovanja() {
    }

}