package fr.solutec.resaevent.entites;
import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Agenda agenda;

    //private Evenement evenement;
    //Place place;
    //private Qrcode qrcode;

    public Reservation(){}
    public Reservation(Agenda agenda) {
        this.agenda = agenda;
    }
    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
