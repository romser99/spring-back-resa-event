package fr.solutec.resaevent.entites;
import fr.solutec.resaevent.a_client.entites.Client;
import fr.solutec.resaevent.a_evenement_type.entites.Evenement;

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
    public Reservation(){}

    public Reservation(int id, Agenda agenda, Client client, Evenement evenement) {
        this.id = id;
        this.agenda = agenda;
        this.client = client;
        this.evenement = evenement;
    }

    //Place place;
    //private Qrcode qrcode;
    //

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
}
