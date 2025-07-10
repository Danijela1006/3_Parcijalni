package org.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.dto.PolaznikDto;


@Data
@AllArgsConstructor
@Entity
@Table(name="Polaznik")
public class Polaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PolaznikID")
    private int id;

    @Column(name="Ime")
    private String ime;

    @Column(name="Prezime")
    private String prezime;

    public Polaznik(PolaznikDto polaznikDto) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}