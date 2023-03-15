package fr.solutec.resaevent.controller;


import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Lieu;
import fr.solutec.resaevent.services.LieuService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "lieu", produces = APPLICATION_JSON_VALUE)
@RestController

public class LieuController {
    private LieuService lieuService;

      public LieuController(LieuService lieuService) {
        this.lieuService = lieuService;
    }

    @PostMapping (consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Lieu lieu) {
        //System.out.println("Création d'un lieu");
        this.lieuService.create(lieu);
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Lieu read(@PathVariable int id) {
        Lieu lieu = this.lieuService.read(id);
        return lieu;
    }

    @GetMapping
    public Set<Lieu> search(Map<String, String> params) {
        //System.out.println("Lecture des adresses en fonction du lieu");
        return this.lieuService.search(params);
    }
    @PutMapping
    public void update(@RequestBody Lieu lieu) {
        System.out.println("Mise à jour du lieu");
        this.lieuService.update(lieu);
    }
}
