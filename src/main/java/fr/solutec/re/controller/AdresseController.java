package fr.solutec.re.controller;

import fr.solutec.re.service.AdresseService;
import fr.solutec.re.entites.Adresse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@RequestMapping(path = "adresse", produces = APPLICATION_JSON_VALUE )
@RestController
public class AdresseController {
    private AdresseService adresseService;
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse) {
        System.out.println("[controller] Création d'une nouvelle adresse");
        this.adresseService.create(adresse);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public @ResponseBody Adresse read(@PathVariable int id) {
        System.out.println("[controller] Lecture des adresses");

        return this.adresseService.read(id);
    }
}
