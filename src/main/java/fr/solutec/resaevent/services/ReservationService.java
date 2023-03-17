package fr.solutec.resaevent.services;
import fr.solutec.resaevent.a_client.entites.Client;
import fr.solutec.resaevent.a_client.services.ClientService;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Reservation;
import fr.solutec.resaevent.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private AgendaService agendaService;
    private ClientService clientService;

    public ReservationService(ReservationRepository reservationRepository, AgendaService agendaService, ClientService clientService) {
        this.reservationRepository = reservationRepository;
        this.agendaService = agendaService;
        this.clientService = clientService;
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
    public void save(Reservation reservation){
        //Qrcode qrcode = this.qrcodeService.findById(reservation.getQrcode().getId());
        //Qrcode qrcode = this.qrcodeService.findById(reservation.getQrcode().getId());
        //Place place = this.placeService.findById(reservation.getPlace().getId());
        Client client = this.clientService.findById(reservation.getClient().getId());
        Agenda agenda = this.agendaService.findById(reservation.getAgenda().getId());
        reservation.setClient(client);
        reservation.setAgenda(agenda);
        this.reservationRepository.save(reservation);
    }
    //DELETE
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