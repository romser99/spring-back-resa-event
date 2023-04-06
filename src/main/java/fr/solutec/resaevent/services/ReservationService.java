package fr.solutec.resaevent.services;
import com.google.zxing.WriterException;
import fr.solutec.resaevent.a_client.entites.Client;
import fr.solutec.resaevent.a_client.services.ClientService;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Evenement;
import fr.solutec.resaevent.entites.Place;
import fr.solutec.resaevent.services.QRCodeService;
import fr.solutec.resaevent.entites.Reservation;
import fr.solutec.resaevent.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private AgendaService agendaService;
    private ClientService clientService;
    private EvenementService evenementService;
    private PlaceService placeService;
    private QRCodeService qrCodeService;

    public ReservationService(ReservationRepository reservationRepository,
                              AgendaService agendaService,
                              ClientService clientService,
                              EvenementService evenementService,
                              PlaceService placeService,
                              QRCodeService qrCodeService) {
        this.reservationRepository = reservationRepository;
        this.agendaService = agendaService;
        this.clientService = clientService;
        this.evenementService = evenementService;
        this.placeService = placeService;
        this.qrCodeService = qrCodeService;
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
    public void save(Reservation reservation) throws MessagingException, IOException, WriterException {
        //Place place = this.placeService.findById(reservation.getPlace().getId());
        Evenement evenement = this.evenementService.findById(reservation.getEvenement().getId()).get();
        Client client = this.clientService.findById(reservation.getClient().getId());
        Place place = this.placeService.read(reservation.getPlace().getId());
        Agenda agenda = this.agendaService.findById(reservation.getAgenda().getId());
        reservation.setEvenement(evenement);
        reservation.setClient(client);
        reservation.setPlace(place);
        reservation.setAgenda(agenda);
        Reservation reservationInDatabase  = this.reservationRepository.save(reservation);
        reservationInDatabase = this.reservationRepository.findById(reservationInDatabase.getId()).get();
        this.qrCodeService.createQRC(reservationInDatabase);
    }
    //DELETE
    public Reservation deleteById(int id){
        this.reservationRepository.deleteById(id);
        return null;
    }
}