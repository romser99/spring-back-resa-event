package fr.solutec.resaevent.controller;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.services.AgendaService;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "agenda", produces = APPLICATION_JSON_VALUE)
@RestController
public class AgendaController {
    private AgendaService agendaService;
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }
    @PostMapping (consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Agenda agenda){
        System.out.println("Création d'un nouvel agenda");
        this.agendaService.create(agenda);
    }
    @GetMapping
    public @ResponseBody Set<Agenda> readAll() {
        System.out.println("Lecture du calendrier");
        return this.agendaService.readAll();
    }
    @PutMapping
    public void update(@RequestBody Agenda agenda) {
        System.out.println("Mise à jour du calendrier");
        this.agendaService.update(agenda);
    }
    @DeleteMapping
    public void delete(@RequestBody Agenda agenda) {
        System.out.println("Suppression du calendrier");
        this.agendaService.delete(agenda);
    }

}
