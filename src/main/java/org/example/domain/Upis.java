package org.example.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Upis")

public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UpisId")
    private int id;

    @ManyToOne
    @JoinColumn(name="IDProgramObrazovanja")
    private ProgramObrazovanja program;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="IDPolaznik")
    private Polaznik polaznik;

    public int getUpisId() {return id;}
    public void setUpisId(int upisId) {this.id = upisId;}

    public ProgramObrazovanja getProgramObrazovanja() {
        return program;
    }

    public void setProgramObrazovanja(ProgramObrazovanja programObrazovanja) {
        this.program = programObrazovanja;
    }

}
