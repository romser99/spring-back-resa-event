package fr.solutec.resaevent.services;


import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Reservation;
import fr.solutec.resaevent.repository.ReservationRepository;

import java.util.Optional;

public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    //SEARCH
    public Iterable<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }
    //READ
    public Optional<Reservation> findById(int id) {
        return this.reservationRepository.findById(id);
    }
    //CREATE + UPDATE
    public Reservation save(Reservation reservation){
        return this.reservationRepository.save(reservation);
    }
    //SEARCH
    public Reservation deleteById(int id){
        this.reservationRepository.deleteById(id);
        return null;
    }
}
    /*
    AgendaService agendaService;
    RoleService roleService;
    public Reservation create () {
        agendaService = new AgendaService();
        Agenda agenda = agendaService.create();
        roleService = new RoleService();
        Role admin = new Role();
        admin.setLibelle("admin");
        Role role = roleService.create(admin);
        Reservation resa = new Reservation();
        resa.setRole(role);
        resa.setAgenda(agenda);
        resa.setResa_evenement("EVENEMENT");
        resa.setResa_place("2 places");
        return resa;
    }

    public void display (Reservation resa){
        System.out.println(
            "la réservation du client numéro " + resa.getRole().getId() +
            " de l'évenement " + resa.getResa_evenement() +
            " du " + resa.getAgenda().getDateDebut() + " au " +resa.getAgenda().getDateFin()  +
            " pour " + resa.getResa_place() + " est validé.");
    }
    */