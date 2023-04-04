package fr.solutec.re.entites;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "AGENDA")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private Time horaireDebut;
    private Time horaireFin;
    @OneToOne
    @JoinColumn (name ="id_evenement")
    private Evenement evenement;
    public Agenda(){}

    public Agenda(int id, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, Evenement evenement) {
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Time getHoraireDebut() {
        return horaireDebut;
    }

    public void setHoraireDebut(Time horaireDebut) {
        this.horaireDebut = horaireDebut;
    }

    public Time getHoraireFin() {
        return horaireFin;
    }

    public void setHoraireFin(Time horaireFin) {
        this.horaireFin = horaireFin;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}