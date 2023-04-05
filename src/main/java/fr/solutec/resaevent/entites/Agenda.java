package fr.solutec.resaevent.entites;
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
    @JoinColumn(name = "id_salle")
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Salle salle;
    public Agenda(){}

    public Agenda(int id, LocalDate dateDebut, LocalDate dateFin, LocalTime horaireDebut, LocalTime horaireFin, Evenement evenement, Salle salle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.horaireDebut = horaireDebut;
        this.horaireFin = horaireFin;
        this.evenement = evenement;
        this.salle = salle;
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

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}