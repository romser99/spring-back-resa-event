package fr.solutec.re.controller;

import fr.solutec.re.service.SalleService;
import fr.solutec.re.entites.Salle;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "salle", produces = APPLICATION_JSON_VALUE)
@RestController
public class SalleController {
        private SalleService salleService;

        public SalleController(SalleService salleService) {
            this.salleService = salleService;
        }

        @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
        public void create(@RequestBody Salle salle) {
            System.out.println("[controller] Création d'une nouvelle salle");
            this.salleService.create(salle);
        }

        @RequestMapping(method = RequestMethod.GET)
        public @ResponseBody Set<Salle> readAll() {
            System.out.println("[controller] Lecture des salles");

            return this.salleService.readAll();
        }

        /*
    @CrossOrigin
    @GetMapping (path = "{id}")
    public int idByNom(@PathVariable int id) {
        return this.salleService.idById(id);
    }

         */
    }


