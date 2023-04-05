package fr.solutec.resaevent.entites;
import fr.solutec.resaevent.entites.Client;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn (name ="id_agenda")
    private Agenda agenda;
    @OneToOne
    @JoinColumn (name ="id_client")
    private Client client;
    @OneToOne
    @JoinColumn (name ="id_evenement")
    private Evenement evenement;
    @OneToOne
    @JoinColumn (name ="id_place")
    private Place place;
    public Reservation(){}

    public Reservation(int id, Agenda agenda, Client client, Evenement evenement, Place place) {
        this.id = id;
        this.agenda = agenda;
        this.client = client;
        this.evenement = evenement;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Evenement getEvenement() {
        return evenement;
    }
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
