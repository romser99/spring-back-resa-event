package fr.solutec.resaevent.controller;
import java.util.Set;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.services.SalleService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RequestMapping(
        path = {"salle"},
        produces = APPLICATION_JSON_VALUE)
@RestController
public class SalleController {
    private SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping
    public void save(@RequestBody Salle salle) {
        System.out.println("[controller] Création d'une nouvelle salle");
        this.salleService.save(salle);
    }

    @GetMapping
    public @ResponseBody Iterable<Salle> findAll() {
        System.out.println("[controller] Lecture des salles");
        return this.salleService.findAll();
    }
}
