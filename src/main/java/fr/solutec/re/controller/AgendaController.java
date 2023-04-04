package fr.solutec.re.controller;
import fr.solutec.re.entites.Agenda;
import fr.solutec.re.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RequestMapping(path = "agenda", produces = APPLICATION_JSON_VALUE)
@RestController
public class AgendaController {
    private AgendaService agendaService;
    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    //SEARCH
    @GetMapping (path = "{idevt}")
    public Set<Agenda> readparevt(@PathVariable int idevt) {
        return this.agendaService.readparevt(idevt);
    }
    //CREATE
    @PostMapping (consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody Agenda agenda){
        System.out.println("Création d'une nouvelle date");
        this.agendaService.save(agenda);
    }
    //READ
    @GetMapping
    public Agenda findById(@PathVariable int id) {
        System.out.println("Lecture d'une adresse");
        return this.agendaService.findById(id);
    }
    //UPDATE
    @PutMapping
    public void saveUpdate(@RequestBody Agenda agenda) {
        System.out.println("Mise à jour du calendrier");
        this.agendaService.save(agenda);
    }
    //DELETE
    @DeleteMapping (path = "{id}")
    public Agenda deleteById(@PathVariable int id) {
        System.out.println("Suppression d'une date du calendrier");
        this.agendaService.deleteById(id);
        return null;
    }
}