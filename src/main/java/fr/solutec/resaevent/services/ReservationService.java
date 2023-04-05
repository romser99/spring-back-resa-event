package fr.solutec.resaevent.services;
import fr.solutec.resaevent.a_client.services.ClientService;
import fr.solutec.resaevent.entites.Evenement;
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
    private EvenementService evenementService;

    public ReservationService(ReservationRepository reservationRepository,
                              AgendaService agendaService,
                              ClientService clientService,
                              EvenementService evenementService) {
        this.reservationRepository = reservationRepository;
        this.agendaService = agendaService;
        this.clientService = clientService;
        this.evenementService = evenementService;
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
        //Place place = this.placeService.findById(reservation.getPlace().getId());
        /*Evenement evenement = this.evenementService.create(reservation.getEvenement().getId());
        Client client = this.clientService.findById(reservation.getClient().getId());
        Agenda agenda = this.agendaService.findById(reservation.getAgenda().getId());
        reservation.setEvenement(evenement);
        reservation.setClient(client);
        reservation.setAgenda(agenda);*/
        this.reservationRepository.save(reservation);
    }
    //DELETE
    public Reservation deleteById(int id){
        this.reservationRepository.deleteById(id);
        return null;
    }
}