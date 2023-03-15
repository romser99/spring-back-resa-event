package fr.solutec.resaevent.entites;

public class Reservation {

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
