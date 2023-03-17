package fr.solutec.resaevent.entites;
import fr.solutec.resaevent.a_client.entites.Client;
import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Agenda agenda;
    @OneToOne
    private Client client;
    public Reservation(){}

    public Reservation(int id, Agenda agenda, Client client) {
        this.id = id;
        this.agenda = agenda;
        this.client = client;
    }

    //private Evenement evenement;
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
}
