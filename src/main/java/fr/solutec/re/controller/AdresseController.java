package fr.solutec.re.controller;


import fr.solutec.re.entites.Adresse;
import fr.solutec.re.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "adresse", produces = APPLICATION_JSON_VALUE)
public class AdresseController {

    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse) {
        System.out.println("[Controller] Creation nouvelle adresse");
        this.adresseService.create(adresse);
    }

    @RequestMapping(method = GET)
    public @ResponseBody Iterable<Adresse> readAll() {
        System.out.println("Lecture des adresses");
        return this.adresseService.readAll();
    }
}
