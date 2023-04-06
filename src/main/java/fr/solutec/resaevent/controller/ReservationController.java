package fr.solutec.resaevent.controller;
import com.google.zxing.WriterException;
import fr.solutec.resaevent.entites.Reservation;
import fr.solutec.resaevent.services.ReservationService;
import fr.solutec.resaevent.utils.EmailSenderService;
import fr.solutec.resaevent.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RequestMapping(path = "reservation", produces = APPLICATION_JSON_VALUE)
@RestController
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    //SEARCH
    @GetMapping
    public @ResponseBody Iterable<Reservation> findAll() {
        System.out.println("Affichage de l'ensemble des réservations");
        return this.reservationService.findAll();
    }
    //CREATE
    @PostMapping (consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Reservation reservation) throws IOException, WriterException, MessagingException {
        System.out.println("Création d'une nouvelle réservation");
        this.reservationService.save(reservation);
    }
    //READ
    @GetMapping (path = "{id}")
    public @ResponseBody Optional<Reservation> findById(@PathVariable int id) {
        System.out.println("Affichage de la réservation");
        return this.reservationService.findById(id);
    }
    //UPDATE
    @PutMapping
    public void update(@RequestBody Reservation reservation) throws MessagingException, IOException, WriterException {
        System.out.println("Mise à jour de la réservation");
        this.reservationService.save(reservation);
    }
    //DELETE
    @DeleteMapping (path = "{id}")
    public Reservation deleteById(@PathVariable int id) {
        System.out.println("Suppression de la réservation");
        this.reservationService.deleteById(id);
        return null;
    }
}