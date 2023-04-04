package fr.solutec.resaevent.entites;
import fr.solutec.resaevent.a_evenement_type.entites.Evenement;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "AGENDA")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime horaireDebut;
    private LocalTime horaireFin;
    @ManyToOne (cascade = {CascadeType.MERGE})
    @JoinColumn (name ="id_evenement")
    private Evenement evenement;
    public Agenda(){}

    public Agenda(int id, LocalDate dateDebut, LocalDate dateFin, LocalTime horaireDebut, LocalTime horaireFin, Evenement evenement) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.horaireDebut = horaireDebut;
        this.horaireFin = horaireFin;
        this.evenement = evenement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalTime getHoraireDebut() {
        return horaireDebut;
    }

    public void setHoraireDebut(LocalTime horaireDebut) {
        this.horaireDebut = horaireDebut;
    }

    public LocalTime getHoraireFin() {
        return horaireFin;
    }

    public void setHoraireFin(LocalTime horaireFin) {
        this.horaireFin = horaireFin;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}