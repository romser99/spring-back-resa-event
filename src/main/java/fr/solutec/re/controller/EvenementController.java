package fr.solutec.re.controller;

import fr.solutec.re.Service.EvenementService;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "evenement", produces = APPLICATION_JSON_VALUE)
@RestController
public class EvenementController {
    private EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Evenement evenement) {
        System.out.println("[controller] Création d'un nouvel évènement");
        this.evenementService.create(evenement);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Set<Evenement> readAll() {
        System.out.println("[controller] Lecture des évènements");

        return this.evenementService.readAll();
    }
}
